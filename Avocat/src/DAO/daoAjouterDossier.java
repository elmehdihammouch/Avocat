package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Client;

public class daoAjouterDossier {
	public static	int  chercherDossier(String CIN) {
		ResultSet res;
		int exist=0;
		
		Connexion.connect();
		res=Connexion.select("SELECT * FROM dossier d,client c WHERE d.idClient = c.idClient and upper(c.cin) LIKE '"+CIN.toUpperCase()+"';");
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
	public static int ajoutclient(Client client) {
		Connexion.connect();
		
		Connexion.disconect();
		return 0;
		
	}
}
