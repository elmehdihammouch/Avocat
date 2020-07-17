package DAO;

import java.sql.ResultSet; 
import java.sql.SQLException;

import models.Administrateur;
import models.Client;
import models.Compte;


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
		
		public static Compte clientAuthentification(String email, String password) {
			ResultSet res;
			Compte client=new Compte();
			
			Connexion.connect();
			res=Connexion.select("select * from compte where emailClient='"+email+"' and passwordCliient='"+password+"' and statut =1 ");			
			try {
				if(res.next()) {
					client.setIdCompte(res.getInt(1));
					client.setIdClient(res.getInt(2));
					client.setEmailCl(res.getString(3));
					client.setPasswordCl(res.getString(4));
					client.setStatut(res.getInt(5));
					
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
