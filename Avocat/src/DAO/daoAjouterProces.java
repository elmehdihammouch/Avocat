package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import models.Client;
import models.Dossier;
import models.Facture;
import models.Files;
import models.Proces;
import tools.Date;

public class daoAjouterProces {

	public static	int  clientExist(String cin) {
		ResultSet res;
		int exist=0;
		
		Connexion.connect();
		res=Connexion.select("select * from client  where upper(cin)='"+cin.toUpperCase()+"'; ");
		try {
			if(res.next()) {
				exist=1;
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("erreur dans la select de la methode chercherDossier");
			}
		Connexion.disconect();
		return exist;
	
	}
	
	public static Client chercherClient(String cin) {
		
		ResultSet res;
		Client c= new Client();
		
		Connexion.connect();
		res=Connexion.select("select * from client where idClient= (select idClient from client where upper(cin)='"+cin.toUpperCase()+"' ); ");
		try {
			if(res.next()) {
				c.setId(res.getInt(1));
				c.setNom(res.getString(2));
				c.setPrenom(res.getString(3));
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("erreur dans la select de la methode chercherDossier");
			}
		Connexion.disconect();
		return c;
		
	}
	
	public static int ajouterProces(Proces p) { 
		int res;
		ResultSet res1;
		Connexion.connect();
		res=Connexion.maj("insert into proces (idDos, description, adresseAdv, cinAdv, nomAdv, prenomAdv, avocatAdv, dateNotif, statut) values('"+p.getIdDos()+"','"+p.getDescription()+"','"+p.getAdresseAdv()+"','"+p.getCinAdv()+"','"+p.getNomAdv()+"','"+p.getPrenomAdv()+"','"+p.getAvocatAdv()+"','"+p.getDateNotif().getDate()+"','"+p.getStatut()+"');");
		//ajout de la facture dans le cas ou l'ajout des donnes du proces ont été realisé avec succes
		if(res==1) {
					res1=Connexion.select("select max(idProces) from proces");
						try {
							if(res1.next()) {
								p.setIdProces(res1.getInt(1)) ;
								
										}
						
						} catch (SQLException e) {
							e.printStackTrace();
							System.out.println("erreur lors de la selection du max(idProces)");
						}
		res=Connexion.maj("INSERT INTO facture (idProces, mtGlobal, mtBase, mtPaye, datePayement) values("+p.getIdProces()+","+p.getFacture().getMtGlobal()+","+p.getFacture().getMtBase()+","+p.getFacture().getMtpaye()+",'"+p.getFacture().getDatePayement().getDate()+"');");	
		}else {System.out.println("ajout du proces a echoué");}
		//ajout des fichiers dans le cas ou l'ajout de la facture a été realisé avec succes
		if(res==1) {
			for (Files f : p.getFiles()) {
				String path = f.getPath().replace("\\", "\\\\");
				res=Connexion.maj("INSERT INTO piece (idProces, nomFichier, path) VALUES ("+p.getIdProces()+",'"+f.getNomFichier()+"','"+path+"');");	
			}
		}
		if(res==1) {System.out.println("tous etaient ajoutés avec succes");}
		
		Connexion.disconect();
		return res;
	}
	
	public static ArrayList<Dossier> dossierClient(String cin){
		ResultSet res;
		ArrayList<Dossier> dossiers = new ArrayList<Dossier>();
		Connexion.connect();
		res=Connexion.select("select d.idDos, d.idClient, d.typeProces, d.description from dossier d where d.idClient=(select idClient from client where upper(cin)='"+cin.toUpperCase()+"' ) AND 3>(select max(p.statut) from proces p where d.idDos=p.idDos); ");
		try {
			while(res.next()) {
				Dossier d = new Dossier(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4));
				dossiers.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connexion.disconect();
		return dossiers;
	}
	
	public static HashMap<String, Proces> consulterProces(){
		ResultSet res;
		HashMap<String, Proces> procesM = new HashMap<String, Proces>();
		
		Connexion.connect();
		//adding proces objects which had files on it to the hashMAP
		res=Connexion.select("SELECT p.idProces, p.idDos, p.numP, p.dateCP, p.dateAP, p.description, p.adresseAdv, p.cinAdv, p.nomAdv, p.prenomAdv, p.avocatAdv, p.tribunal, p.ville, p.saleNum, p.dateSeance, p.dateSui, p.txtJug, p.dateJug, p.dateNotif, p.statut, c.prenom, c.nom, f.idFacture, f.mtGlobal, f.mtPaye, pi.idPiece, pi.nomFichier, pi.path FROM proces p,dossier d, client c, facture f, piece pi  WHERE p.idDos=d.idDos AND d.idClient=c.idClient AND p.idProces=f.idProces AND p.idProces=pi.idProces;");
		try {
			
			while(res.next()) {
				
				Facture facture = new Facture(res.getInt(23), res.getFloat(24), res.getFloat(25)) ;
				
				
				Files file = new Files(res.getInt(26), res.getInt(1), res.getString(27), res.getString(28));
				
				//------------ making proces objects and adding them to the hashMap procesM
				//----for each resultSet we check if the proces brought by it doesn't exist in the hashMap procesM
				int iterator=0;
				for(Proces p: procesM.values()) {
					if (p.getIdProces()==res.getInt(1)) {
						p.getFiles().add(file);
						break;
					}
					else {iterator++;}
				}
				//------------------ if it doesn't we wreate a new set in that hashMap procesM
				if(iterator==procesM.size()) {
					ArrayList<Files> files = new ArrayList<Files>();
					files.add(file);
					Proces proces = new Proces(res.getInt(1), res.getInt(2), res.getString(3),Date.toToolsDate(res.getTimestamp(4)) , Date.toToolsDate(res.getTimestamp(5)), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14), Date.toToolsDate(res.getTimestamp(15)), Date.toToolsDate(res.getTimestamp(16)), res.getString(17), Date.toToolsDate(res.getTimestamp(18)), files , facture,Date.toToolsDate(res.getTimestamp(19)), res.getInt(20));
					procesM.put(res.getString(21)+" "+res.getString(22), proces);
				}
				//-----------
			}
		//	adding proces objects which doesn not have files on it to the hashMAP
		res=Connexion.select("SELECT p.idProces, p.idDos, p.numP, p.dateCP, p.dateAP, p.description, p.adresseAdv, p.cinAdv, p.nomAdv, p.prenomAdv, p.avocatAdv, p.tribunal, p.ville, p.saleNum, p.dateSeance, p.dateSui, p.txtJug, p.dateJug, p.dateNotif, p.statut, c.prenom, c.nom, f.idFacture, f.mtGlobal, f.mtPaye FROM proces p,dossier d, client c, facture f WHERE p.idDos=d.idDos AND d.idClient=c.idClient AND p.idProces=f.idProces AND p.idProces not in (select pi.idProces from piece pi)");
		while(res.next()) {
			
			Facture facture = new Facture(res.getInt(23), res.getFloat(24), res.getFloat(25)) ;
			Proces proces = new Proces(res.getInt(1), res.getInt(2), res.getString(3),Date.toToolsDate(res.getTimestamp(4)) , Date.toToolsDate(res.getTimestamp(5)), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14), Date.toToolsDate(res.getTimestamp(15)), Date.toToolsDate(res.getTimestamp(16)), res.getString(17), Date.toToolsDate(res.getTimestamp(18)), facture,Date.toToolsDate(res.getTimestamp(19)), res.getInt(20));
			procesM.put(res.getString(21)+" "+res.getString(22), proces);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connexion.disconect();
		return procesM;
	}
	
	public static Proces procesById(int id) {
		Proces proces = null ;
		ResultSet res;
		Connexion.connect();
		res=Connexion.select("SELECT p.idProces, p.idDos, p.numP, p.dateCP, p.dateAP, p.description, p.adresseAdv, p.cinAdv, p.nomAdv, p.prenomAdv, p.avocatAdv, p.tribunal, p.ville, p.saleNum, p.dateSeance, p.dateSui, p.txtJug, p.dateJug, p.dateNotif, p.statut, c.prenom, c.nom, f.idFacture, f.mtGlobal, f.mtPaye,f.mtBase,  f.datePayement  FROM proces p,dossier d, client c, facture f  WHERE p.idDos=d.idDos AND d.idClient=c.idClient AND p.idProces=f.idProces AND p.idProces="+id+";");
		try {
			if(res.next()) {//f.idFacture, f.mtGlobal, f.mtPaye,f.mtBase,  f.datePayement
				Facture facture = new Facture(res.getInt(23), res.getInt(1), Date.toToolsDate(res.getTimestamp(27)) , res.getFloat(26), res.getFloat(24), res.getFloat(25));			   
				proces = new Proces(res.getInt(1), res.getInt(2), res.getString(3),Date.toToolsDate(res.getTimestamp(4)) , Date.toToolsDate(res.getTimestamp(5)), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14), Date.toToolsDate(res.getTimestamp(15)), Date.toToolsDate(res.getTimestamp(16)), res.getString(17), Date.toToolsDate(res.getTimestamp(18)), facture,Date.toToolsDate(res.getTimestamp(19)), res.getInt(20));
				res=Connexion.select("SELECT idPiece, idProces, nomFichier, path FROM piece WHERE idProces="+id+";");
				ArrayList<Files> files = new ArrayList<Files>();
				while(res.next()) {
					Files file = new Files(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4));
					files.add(file);
				}
				proces.setFiles(files);
			}
			Connexion.disconect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proces;
		
	}
	
	
	public static int procesUpdate(Proces p) {
		ResultSet res;
		int result = 0;
		Connexion.connect();
		try {
		//selection des donnes du proces pour les mettre dans procesArch
		res = Connexion.select("SELECT  idProces, adresseAdv, nomAdv, prenomAdv, avocatAdv, tribunal, ville, saleNum, dateSeance, dateSui, txtJug, dateJug FROM proces WHERE idProces="+p.getIdProces()+" ;");
		
				if(res.next()) {
					Proces pi=new Proces(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), Date.toToolsDate(res.getTimestamp(9)), Date.toToolsDate(res.getTimestamp(10)),res.getString(11), Date.toToolsDate(res.getTimestamp(12)));
					pi = Proces.procesCheck(pi);
					result = Connexion.maj("INSERT INTO procesarch(idProces, adresseAdv, nomAdv, prenomAdv, avocatAdv, tribunal, ville, saleNum, dateSeance, dateSui, txtJug, dateJug) VALUES ("+pi.getIdProces()+", "+pi.getAdresseAdv()+", "+pi.getNomAdv()+", "+pi.getPrenomAdv()+", "+pi.getAvocatAdv()+", "+pi.getTribunal()+", "+pi.getVille()+", "+pi.getSaleNum()+", "+Date.toDBCheck(pi.getDateSeance())+", "+Date.toDBCheck(pi.getDateSui())+", "+pi.getTxtJug()+", "+Date.toDBCheck(pi.getDateJug())+");");
				}
		//modification dans proces
				if(result==1) {
					result=Connexion.maj("UPDATE proces SET numP="+p.getNumP()+" , dateAP="+Date.toDBCheck(p.getDateAP())+" , description="+p.getDescription()+" , adresseAdv="+p.getAdresseAdv()+" , cinAdv="+p.getCinAdv()+" , nomAdv="+p.getNomAdv()+" , prenomAdv="+p.getPrenomAdv()+" , avocatAdv="+p.getAvocatAdv()+" , tribunal="+p.getTribunal()+" , ville="+p.getVille()+" , saleNum="+p.getSaleNum()+" , dateSeance="+Date.toDBCheck(p.getDateSeance())+" , dateSui="+Date.toDBCheck(p.getDateSui())+" , txtJug="+p.getTxtJug()+" , dateJug="+Date.toDBCheck(p.getDateJug())+" , dateNotif="+Date.toDBCheck(p.getDateNotif())+" where idProces="+p.getIdProces()+" ;");
				}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		Connexion.disconect();
		return result;
	}
	
	public static int factureUpdate(Facture f) {
		int res=0;
		Connexion.connect();
		res = Connexion.maj("INSERT INTO facturearch(idFacture, datePayement, lgKm, prKm, dureeJr, prixJr, mtPaye) VALUES ( (select idFacture FROM facture WHERE idProces="+f.getIdProces()+"), "+Date.toDBCheck(f.getDatePayement())+", "+f.getLgKm()+", "+f.getPrKm()+", "+f.getDureeJr()+", "+f.getPrixJr()+", "+f.getMtPayeAjoute()+" );");
		if(res==1) {
			res = Connexion.maj("UPDATE facture SET mtGlobal= (select mtGlobal from facture where idProces="+f.getIdProces()+")+("+f.getLgKm()*f.getPrKm()+")+("+f.getPrixJr()*f.getDureeJr()+"), mtPaye="+(f.getMtpaye()+f.getMtPayeAjoute())+", datePayement="+Date.toDBCheck(f.getDatePayement())+" where idProces="+f.getIdProces()+";");
			if(res==0) {
				Connexion.maj("DELETE FROM facturearch WHERE idFactureArch=(select max(idFactureArch) from facturearch)");
			}
		}
		Connexion.disconect();
		return res;
		
	}
	
	public static Facture FactureByIdProces(int idProces) {
		ResultSet res;
		Facture f = null;
		Connexion.connect();
		res=Connexion.select("SELECT idFacture,idProces,datePayement,mtBase,mtGlobal,mtPaye FROM facture WHERE idProces="+idProces+";");
		try {
			if(res.next()) {
			f=new Facture(res.getInt(1), res.getInt(2), Date.toToolsDate(res.getTimestamp(3)), res.getFloat(4), res.getFloat(5), res.getFloat(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connexion.disconect();
		return f;
	}
	
	public static int supprimerProces(int idProces) {
		int res;
		Connexion.connect();
		
		Connexion.maj("DELETE FROM piece WHERE idProces="+idProces+";");
		Connexion.maj("DELETE FROM facture WHERE idProces="+idProces+";");
		Connexion.maj("DELETE FROM facturearch WHERE idFacture = (select idFacture from facture where idProces="+idProces+");");
		Connexion.maj("DELETE FROM procesarch WHERE idProces="+idProces+";");
		res=Connexion.maj("DELETE FROM proces WHERE idProces="+idProces+";");
			
		Connexion.disconect();
		return res;
	}
	
	public static int supprimerPiece(String nomFichier) {
		int res;
		Connexion.connect();
		res = Connexion.maj("DELETE FROM piece WHERE nomFichier='"+nomFichier+"';");
		Connexion.disconect();
		return res;
		
	}
	
	public static int fileUploadDB(ArrayList<Files> F,int idProces) {
		int res = 0;
		Connexion.connect();
		for (Files f : F) {
			String path = f.getPath().replace("\\", "\\\\");
			res=Connexion.maj("INSERT INTO piece (idProces, nomFichier, path) VALUES ("+idProces+",'"+f.getNomFichier()+"','"+path+"');");	
		}
		Connexion.disconect();
		return res;
	}
	

}
