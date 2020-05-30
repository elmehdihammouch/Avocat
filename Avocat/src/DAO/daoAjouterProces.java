package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Files;
import models.Proces;

public class daoAjouterProces {

	public static	int  chercherDossier(String cin) {
		ResultSet res;
		int exist=0;
		
		Connexion.connect();
		res=Connexion.select("select * from dossier where idClient= (select idClient from client where cin='"+cin+"' ); ");
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
				res=Connexion.maj("INSERT INTO piece (idProces, nomFichier, path) VALUES ("+p.getIdProces()+",'"+f.getNomFichier()+"','"+f.getIdPiece()+"');");	
			}
		}
		if(res==1) {System.out.println("tous etaient ajoutés avec succes");}
		
		Connexion.disconect();
		return res;
	}
	
	

}
