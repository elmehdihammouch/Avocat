package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Client;
import models.Dossier;

public class daoAjouterDossier {
	public static	int  chercherDossier(String CIN) {
		ResultSet res;
		int exist=0;
		
		Connexion.connect();
		res=Connexion.select("SELECT * FROM client c WHERE upper(c.cin) LIKE '"+CIN.toUpperCase()+"';");
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
	public static	int  chercherEtatCompte(String CIN) {
		ResultSet res;
		int exist=0;
		
		Connexion.connect();
		res=Connexion.select("SELECT idClient FROM client c WHERE upper(c.cin) LIKE '"+CIN.toUpperCase()+"';");
		try {
		res.next();
		exist = res.getInt(1);
		res = Connexion.select("SELECT idClient FROM compte where idClient="+exist+"");
		if(res.next()) {exist = 1;}else {exist = 0;}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("erreur dans la select de la methode chercherDossier");
			}
		Connexion.disconect();
		return exist;
	}
	public static void ajoutclient(Client client) {
		Connexion.connect();
		Connexion.maj("INSERT INTO client (`nom`, `prenom`, `datenais`, `lieunais`, `nat`, `adresse`, `cin`, `municipal`, `tel`) VALUES ('"+client.getNom()+"','"+client.getPrenom()+"','"+client.getDateNais()+"','"+client.getLieuNais()+"','"+client.nationalite+"','"+client.getAdresse()+"','"+client.getCin()+"','"+client.getMunicipale()+"',"+client.getTelephone()+")");
		Connexion.disconect();
		
	}
	public static void ajoutcompte(Client client) {
		ResultSet res;
		Connexion.connect();
		res = Connexion.select("SELECT * FROM client c WHERE upper(c.cin) LIKE '"+client.getCin().toUpperCase()+"';");
		
		try {res.next();
		client.setNom(res.getString("nom")); client.setPrenom(res.getString("prenom"));client.setCin(res.getString("cin"));
			String mail = client.getNom()+client.getPrenom();
			mail = mail.concat(client.getCin().substring(client.getCin().length()-4));
			mail = mail+"@email.com";
			int idClient = res.getInt(1);
			Connexion.maj("INSERT INTO compte (`idClient`, `emailClient`, `passwordCliient`, `statut`) VALUES ("+idClient+" , '"+mail+"' , '"+tools.G_password.generatecode()+"' , 1 )");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connexion.disconect();	
	}
	
	public static void ajoutdossier(Dossier dos , String cin) {
		ResultSet res;
		Connexion.connect();
		res = Connexion.select("SELECT idClient FROM client c WHERE upper(c.cin) LIKE '"+cin.toUpperCase()+"';");
		try {res.next();
			int idClient = res.getInt(1);
			Connexion.maj("INSERT INTO `dossier`(`idClient`, `etatav`, `typeProces`,description) VALUES ("+idClient+",'"+dos.getEtatAv()+"','"+dos.getTypeProces()+"','"+dos.getDescription()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connexion.disconect();
	}
	
	public static int idDos() {
		ResultSet res;
		int idDos = 0;
		Connexion.connect();
		res = Connexion.select("SELECT MAX(idDos) FROM dossier;");
		try {res.next();
			idDos = res.getInt(1);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connexion.disconect();
		return idDos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
