package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class daoFiles {

	public static int filesNames(String fileName) {
		ResultSet res;
		int exist=0;
		Connexion.connect();
		res=Connexion.select("select * from piece where nomFichier='"+fileName+"';");
		try {
			if(res.next()) {
				exist=1;
			}
			else {exist=0;}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connexion.disconect();
		return exist;
		
	}
	
	public static int maxId() {
		ResultSet res;
		int maxId = 0;
		Connexion.connect();
		res=Connexion.select("select max(idPiece) from piece;");
		try {
			res.next();
			maxId=res.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connexion.disconect();
		return maxId;
		
	}
	
}
