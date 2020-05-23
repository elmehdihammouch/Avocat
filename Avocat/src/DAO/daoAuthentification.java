package DAO;

import java.sql.ResultSet; 
import java.sql.SQLException;

import models.Administrateur;
import models.Client;


public class daoAuthentification {

		public static Administrateur adminAuthentification(String email,String password) {
			ResultSet res;
			Administrateur administrateur = new Administrateur();
			
			Connexion.connect();
			res = Connexion.select("select * from administrateur where email='"+email+"' and password='"+password+"';");
			
			try {
				if(res.next()) {
					administrateur.setId(res.getInt(1));
					administrateur.setNom(res.getString(2));
					administrateur.setPrenom(res.getString(3));
					administrateur.setDateNais(res.getDate(4));
					administrateur.setLieuNais(res.getString(5));
					administrateur.setNationalite(res.getString(6));
					administrateur.setCin(res.getString(7));
					administrateur.setEmail(res.getString(8));
					administrateur.setPassword(res.getString(9));
					administrateur.setImageUrl(res.getString(10));
				}
				else {
					return null;
				}
				
				Connexion.disconect();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("erreur avec la requete select de la methode adminAuthentification ");
				return null;
			}
			return administrateur;
		}
		
		public static Client clientAuthentification(String email, String password) {
			ResultSet res;
			Client client=new Client();
			
			Connexion.connect();
			res=Connexion.select("select * from administrateur where email="+email+" and password="+password+"; ");
			
			try {
				if(res.next()) {
					client.setId(res.getInt(1));
					client.setNom(res.getString(2));
					client.setPrenom(res.getString(3));
					client.setDateNais(res.getDate(4));
					client.setLieuNais(res.getString(5));
					client.setNationalite(res.getString(6));
					client.setAdresse(res.getString(7));
					client.setCin(res.getString(8));
					client.setMunicipale(res.getString(9));
					client.setMunicipale(res.getString(10));
					client.setTelephone(res.getString(11));
					client.setEmail(res.getString(12));
					client.setPassword(res.getString(13));
					
				}
				else return null;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("erreur avec la requete select de la methode clientAuthentification ");
				return null;
			}
			
			Connexion.disconect();
			return client;
			
			
		}
		
}
