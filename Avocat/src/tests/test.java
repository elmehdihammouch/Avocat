package tests;




import java.sql.Date;

import DAO.Connexion;


public class test {

	public static void main(String[] args) {
		Connexion.connect();
		Connexion.maj("INSERT INTO client (nom, prenom, datenais, lieunais, nat, adresse, cin, municipal, tel) VALUES ('mm','mm','2020/01/02','casa','moougg','jido','bh16547','judjjj',26453145) ");
		Connexion.disconect();
		
	}

}
