package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		Connexion.maj("INSERT INTO client (`nom`, `prenom`, `datenais`, `lieunais`, `nat`, `adresse`, `cin`, `municipal`, `tel`,`email`) VALUES ('"+client.getNom()+"','"+client.getPrenom()+"','"+client.getDateNais()+"','"+client.getLieuNais()+"','"+client.getNationalite()+"','"+client.getAdresse()+"','"+client.getCin()+"','"+client.getMunicipale()+"',"+client.getTelephone()+",'"+client.getEmail()+"')");
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
	
	
	public static ArrayList<Consultation> listConsultation(){
		ResultSet res;
		ArrayList<Consultation> consultation = new ArrayList<Consultation>();
		Connexion.connect();
		res=Connexion.select("select cl.nom,cl.prenom,cl.cin ,cl.tel,cl.email, co.* from consultation co left outer join client cl ON cl.idClient = co.idClient");
		try {
			while(res.next()) { 
				Client client = new Client(res.getInt(7), res.getString(1), res.getString(2),res.getString(3), res.getString(4), res.getString(5));
				Consultation consultations = new Consultation(res.getInt(6), res.getString(8), res.getString(9), res.getFloat(10), client);
				consultation.add(consultations);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connexion.disconect();
		return consultation;
		
	}
	
	public static int delete(int id){
		int nbr = 0;
		Connexion.connect();
		nbr += Connexion.maj("DELETE FROM `consultation` WHERE idConsultation = "+id+"");		
		return nbr;
	}
	
}
