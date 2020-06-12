package tests;





import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONObject;

import DAO.Connexion;
import DAO.daoAjouterProces;
import DAO.daoFiles;
import models.Client;
import models.Dossier;
import models.Files;
import models.Proces;
import tools.Date;


public class test {

	
	@SuppressWarnings("unchecked")
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
		
	
		//java.util.Date datePay = new SimpleDateFormat("yyyy-MM-dd").parse("1776-7-4 04:13:54");
		
		/*java.sql.Date d2 = new java.sql.Date(datePay.getTime());*/
		
		/*DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = datePay.format(myFormatObj);*/
		/*String d2 = "2000-11-11 12:12:12";
		Proces p=new Proces(2, "description", "adresseAdv", "cinAdv", "nomAdv", "prenomAdv", "avocatAdv",datePay, 2);*/
		//daoAjouterProces.ajouterProces(p);
		//int res;
		/*Connexion.connect();
		res=Connexion.maj("insert into proces (idDos, description, adresseAdv, cinAdv, nomAdv, prenomAdv, avocatAdv, dateNotif, statut) values("+p.getIdDos()+",'"+p.getDescription()+"','"+p.getAdresseAdv()+"','"+p.getCinAdv()+"','"+p.getNomAdv()+"','"+p.getPrenomAdv()+"','"+p.getAvocatAdv()+"','"+p.getDateNotifd()+"','"+p.getStatut()+"')");
		Connexion.disconect();
		System.out.println(res);*/
		
		//Date d= Date.toDbDate("2020-05-22T22:15");
	
		   /*   JSONObject obj = new JSONObject();

		      Client client=daoAjouterProces.chercherClient("bh1212");
				obj.put("exist", 1 );
				obj.put("clientID", client.getId() );
				obj.put("clientNom", client.getNom() );
				obj.put("clientPrenom", client.getPrenom() );

		      System.out.print(obj);*/
	//String 	fileName ="aa";
	
	//System.out.println(FilenameUtils.removeExtension(fileName)+"."+FilenameUtils.getExtension(fileName));
	/*-----------------int inc=1;
	String incS="("+inc+")";
    String nameWithOutExtension;
    String extension ;
    System.out.println("existance "+daoFiles.filesNames(fileName));
	 while(daoFiles.filesNames(fileName)==1) {
 	    nameWithOutExtension = FilenameUtils.removeExtension(fileName);
 	    extension = FilenameUtils.getExtension(fileName);
 	    if (nameWithOutExtension.endsWith(incS)) {inc++;
 	   nameWithOutExtension = nameWithOutExtension.substring(0, nameWithOutExtension.lastIndexOf(incS)-4);
 	   nameWithOutExtension = nameWithOutExtension+incS;
	    fileName = nameWithOutExtension+"."+extension;
 	    }
 	    else {
 	    nameWithOutExtension = nameWithOutExtension+incS;
 	    fileName = nameWithOutExtension+"."+extension;
 	    inc++;
 	    }
    }------------*/
	  //fileName =fileName+daoFiles.maxId()+1;
		//System.out.println("new name : "+fileName);
	
	// lastIndexOf()  endsWith()
	
	/*Connexion.connect();
	ResultSet res = Connexion.select("SELECT p.idProces, p.idDos, p.numP, p.dateCP, p.dateAP, p.description, p.adresseAdv, p.cinAdv, p.nomAdv, p.prenomAdv, p.avocatAdv, p.tribunal, p.ville, p.saleNum, p.dateSeance, p.dateSui, p.txtJug, p.dateJug, p.dateNotif, p.statut, c.prenom, c.nom, f.idFacture, f.mtGlobal, f.mtPaye, pi.idPiece, pi.nomFichier, pi.path FROM proces p,dossier d, client c, facture f, piece pi  WHERE p.idDos=d.idDos AND d.idClient=c.idClient AND p.idProces=f.idProces AND p.idProces=pi.idProces;");
	try {
		res.next();
		System.out.println(res.getTimestamp(19));
		System.out.println(Date.toToolsDate(res.getTimestamp(19)).toString());
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println();
	
	Connexion.disconect();*/
		
		HashMap<String, Integer> people = new HashMap<String, Integer>();


	    // Add keys and values (Name, Age)
	   /* people.put("John", 32);
	    people.put("Steve", 30);
	    people.put("Angie", 33);*/
	
	
		
	
	
	}
	

}
