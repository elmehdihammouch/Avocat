package tests;





import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import DAO.Connexion;
import DAO.daoAjouterProces;
import models.Proces;
import tools.Date;


public class test {

	public static void main(String[] args) throws ParseException {
		
		/*Connexion.connect();
		Connexion.maj("INSERT INTO client (nom, prenom, datenais, lieunais, nat, adresse, cin, municipal, tel) VALUES ('mm','mm','2020/01/02','casa','moougg','jido','bh16547','judjjj',26453145) ");
		Connexion.disconect()
		INSERT INTO TABLE(col_datetime) VALUES('1776-7-4 04:13:54');
		*/
		/*String a=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String datePayS= "22-jan-2000 12:12";*/
		
		//java.util.Date date = new SimpleDateFormat("dd-MMM-yyyy HH:mm.", Locale.ENGLISH).parse(datePayS);
		
		//Date datePay = null;
		
			/*	try {
					 datePay = (Date) sdf.parse(datePayS);
					 
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		
	
		java.util.Date datePay = new SimpleDateFormat("yyyy-MM-dd").parse("1776-7-4 04:13:54");
		
		/*java.sql.Date d2 = new java.sql.Date(datePay.getTime());*/
		
		/*DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = datePay.format(myFormatObj);*/
		/*String d2 = "2000-11-11 12:12:12";
		Proces p=new Proces(2, "description", "adresseAdv", "cinAdv", "nomAdv", "prenomAdv", "avocatAdv",datePay, 2);*/
		//daoAjouterProces.ajouterProces(p);
		int res;
		/*Connexion.connect();
		res=Connexion.maj("insert into proces (idDos, description, adresseAdv, cinAdv, nomAdv, prenomAdv, avocatAdv, dateNotif, statut) values("+p.getIdDos()+",'"+p.getDescription()+"','"+p.getAdresseAdv()+"','"+p.getCinAdv()+"','"+p.getNomAdv()+"','"+p.getPrenomAdv()+"','"+p.getAvocatAdv()+"','"+p.getDateNotifd()+"','"+p.getStatut()+"')");
		Connexion.disconect();
		System.out.println(res);*/
		
		Date d= Date.toDbDate("2020-05-22T22:15");
		System.out.println(d);
		

	}

}
