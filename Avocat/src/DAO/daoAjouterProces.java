package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

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

}
