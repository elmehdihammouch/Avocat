package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Client;
import models.Dossier;
import models.Files;
import models.Proces;

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
		res=Connexion.maj("insert into proces (idDos, description, adresseAdv, cinAdv, nomAdv, prenomAdv, avocatAdv, dateNotif, statut) values("+p.getIdDos()+",'"+p.getDescription()+"','"+p.getAdresseAdv()+"','"+p.getCinAdv()+"','"+p.getNomAdv()+"','"+p.getPrenomAdv()+"','"+p.getAvocatAdv()+"','"+p.getDateNotif().getDate()+"','"+p.getStatut()+"')");
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
		res=Connexion.maj("INSERT INTO facture (idProces, prKm, mtGlobal, mtBase, mtPaye, datePayement) values("+p.getIdProces()+","+p.getFacture().getPrKm()+","+p.getFacture().getMtGlobal()+","+p.getFacture().getMtBase()+","+p.getFacture().getMtpaye()+",'"+p.getFacture().getDatePayement().getDate()+"');");	
		}else {System.out.println("ajout du proces a echoué");}
		//ajout des fichiers dans le cas ou l'ajout de la facture a été realisé avec succes
		if(res==1) {
			for (Files f : p.getFiles()) {
				res=Connexion.maj("INSERT INTO piece (idProces, nomFichier, path) VALUES ("+p.getIdProces()+",'"+f.getNomFichier()+"','"+f.getPath()+"');");	
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
		res=Connexion.select("select * from dossier where idClient= (select idClient from client where upper(cin)='"+cin.toUpperCase()+"' ); ");
		try {
			while(res.next()) {
				Dossier d = new Dossier(res.getInt(1), res.getInt(2), res.getInt(3), res.getString(4), res.getString(5));
				dossiers.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connexion.disconect();
		return dossiers;
	}

}
