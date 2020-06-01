package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Client;
import models.Consultation;

public class daoAjouterConsultation {
	
	
	
	
	
	
	public static	int  chercherClient(String CIN) {
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
				System.out.println("erreur dans la select de la methode Client");
			}
		Connexion.disconect();
		return exist;
	}
	
	public static void ajoutclient(Client client) {
		Connexion.connect();
		Connexion.maj("INSERT INTO client (`nom`, `prenom`, `datenais`, `lieunais`, `nat`, `adresse`, `cin`, `municipal`, `tel`) VALUES ('"+client.getNom()+"','"+client.getPrenom()+"','"+client.getDateNais()+"','"+client.getLieuNais()+"','"+client.nationalite+"','"+client.getAdresse()+"','"+client.getCin()+"','"+client.getMunicipale()+"',"+client.getTelephone()+")");
		Connexion.disconect();
		
	}
	
	public static void ajoutConsultation(Consultation cons,String cin) {
		ResultSet res;
		Connexion.connect();
		res = Connexion.select("SELECT idClient FROM client c WHERE upper(c.cin) LIKE '"+cin.toUpperCase()+"';");
		try {res.next();
			int idClient = res.getInt(1);
			Connexion.maj("INSERT INTO `consultation`(`idClient`, `typeProces`, `description`, `frais`) VALUES ("+idClient+",'"+cons.getTypeProces()+"','"+cons.getDescription()+"','"+cons.getFrais()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connexion.disconect();
	}
}
