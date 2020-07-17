package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import models.Client;
import models.Compte;
import models.Dossier;




public class daoAjouterDossier {
	public static	int  chercherDossier(String CIN) {
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
				System.out.println("erreur dans la select de la methode chercherDossier");
			}
		Connexion.disconect();
		return exist;
	}
	public static	int  chercherEtatCompte(String CIN) {
		ResultSet res;
		int exist=0;
		
		Connexion.connect();
		res=Connexion.select("SELECT idClient FROM client c WHERE upper(c.cin) LIKE '"+CIN.toUpperCase()+"';");
		try {
		res.next();
		exist = res.getInt(1);
		res = Connexion.select("SELECT idClient FROM compte where idClient="+exist+"");
		if(res.next()) {exist = 1;}else {exist = 0;}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("erreur dans la select de la methode chercherDossier");
			}
		Connexion.disconect();
		return exist;
	}
	public static void ajoutclient(Client client) {
		Connexion.connect();
		Connexion.maj("INSERT INTO client (`nom`, `prenom`, `datenais`, `lieunais`, `nat`, `adresse`, `cin`, `municipal`, `tel`,`email`) VALUES ('"+client.getNom()+"','"+client.getPrenom()+"','"+client.getDateNais()+"','"+client.getLieuNais()+"','"+client.getNationalite()+"','"+client.getAdresse()+"','"+client.getCin()+"','"+client.getMunicipale()+"','"+client.getTelephone()+"','"+client.getEmail()+"')");
		Connexion.disconect();
		
	}
	public static void ajoutcompte(Client client) {
		ResultSet res;
		Connexion.connect();
		res = Connexion.select("SELECT * FROM client c WHERE upper(c.cin) LIKE '"+client.getCin().toUpperCase()+"';");
		
		try {res.next();
		client.setNom(res.getString("nom")); client.setPrenom(res.getString("prenom"));client.setCin(res.getString("cin"));
			String mail = client.getNom()+client.getPrenom();
			mail = mail.concat(client.getCin().substring(client.getCin().length()-4));
			mail = mail+"@email.com";
			int idClient = res.getInt(1);
			Connexion.maj("INSERT INTO compte (`idClient`, `emailClient`, `passwordCliient`, `statut`) VALUES ("+idClient+" , '"+mail+"' , '"+tools.G_password.generatecode()+"' , 1 )");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connexion.disconect();	
	}
	
	public static void ajoutdossier(Dossier dos , String cin) {
		ResultSet res;
		Connexion.connect();
		res = Connexion.select("SELECT idClient FROM client c WHERE upper(c.cin) LIKE '"+cin.toUpperCase()+"';");
		try {res.next();
			int idClient = res.getInt(1);
			Connexion.maj("INSERT INTO `dossier`(`idClient`, `typeProces`,description) VALUES ("+idClient+",'"+dos.getTypeProces()+"','"+dos.getDescription()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connexion.disconect();
	}
	
	public static int idDos() {
		ResultSet res;
		int idDos = 0;
		Connexion.connect();
		res = Connexion.select("SELECT MAX(idDos) FROM dossier;");
		try {res.next();
			idDos = res.getInt(1);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connexion.disconect();
		return idDos;
	}
	
	
	public static int[] findstatut(ArrayList<Dossier> dossier) {
		
		int[] statut = new int[dossier.size()] ;
		ResultSet res = null;	
		Connexion.connect();	
			for (int i =0; i<dossier.size();i++) {
				res = Connexion.select("SELECT max(`statut`) FROM proces,dossier where proces.idDos = "+dossier.get(i).getIdDos()+" and proces.idDos = dossier.idDos");
				try {
					if(res.next()) {
						statut[i] = res.getInt(1);						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		
		Connexion.disconect();
		return statut;
		}
	
	
	public static ArrayList<MyResult> listDossier(){
		ResultSet res;
		Dossier dossier = null;
		MyResult result = null;
		int statut = 0;
		ArrayList<MyResult> dossiers = new ArrayList<MyResult>();
		Connexion.connect();
		res=Connexion.select("select cl.nom,cl.prenom,cl.cin ,cl.tel,cl.email , do.*,max(statut) as 'statut' from dossier do left outer join client cl ON cl.idClient = do.idClient left outer join proces po ON po.idDos = do.idDos GROUP BY do.idDos");
		try {
			while(res.next()) { 
				Client client = new Client(res.getInt(7), res.getString(1), res.getString(2),res.getString(3), res.getString(4), res.getString(5));
				dossier = new Dossier(res.getInt("idDos"), res.getInt("idClient"), res.getString("typeProces"), res.getString("description"),client);
				statut = res.getInt("statut");
				result = new MyResult(dossier, statut);
				dossiers.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connexion.disconect();
		return dossiers;
		
	}
	
	
	
	
	public static class MyResult {
	    private Dossier dossier;
	    private int statut;
		public Dossier getDossier() {
			return dossier;
		}
		public int getStatut() {
			return statut;
		}
		public MyResult(Dossier dossier, int statut) {
			super();
			this.dossier = dossier;
			this.statut = statut;
		}
	}	
	
	public static int modif(MyResult res) {
		Connexion.connect();
		int nbr = Connexion.maj("UPDATE `dossier` left outer join proces ON proces.idDos = dossier.idDos SET dossier.typeProces ='"+res.getDossier().getTypeProces()+"',dossier.description='"+res.getDossier().getDescription()+"',proces.statut='"+res.getStatut()+"' WHERE dossier.idDos ="+res.getDossier().getIdClient());
		Connexion.disconect();
		return nbr;
	}

	public static int delete(int id){
		int idProces , nbr = 0;
		ResultSet res;
		Connexion.connect();
		res=Connexion.select("select idProces from proces where idDos = "+id+"");
		
		try {
			res.next();
			idProces = res.getInt("idProces");
			
	
			nbr += Connexion.maj("DELETE FROM `proces` WHERE idDos = "+id+"");
			nbr += Connexion.maj("DELETE FROM `facture` WHERE idProces = "+idProces+"");
			nbr += Connexion.maj("DELETE FROM `piece` WHERE idProces = "+idProces+"");
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			nbr += Connexion.maj("DELETE FROM `dossier` WHERE idDos = "+id+"");
		}
		
		
		return nbr;
	}
	
	public static ArrayList<MyResult> listDossier(int idClient){
		ResultSet res;
		Dossier dossier = null;
		MyResult result = null;
		int statut = 0;
		ArrayList<MyResult> dossiers = new ArrayList<MyResult>();
		Connexion.connect();
		res=Connexion.select("select cl.nom,cl.prenom,cl.cin ,cl.tel,cl.email , do.*,max(statut) as 'statut' from dossier do left outer join client cl ON cl.idClient = do.idClient left outer join proces po ON po.idDos = do.idDos where cl.idClient="+idClient+" GROUP BY do.idDos");
		try {
			while(res.next()) { 
				Client client = new Client(res.getInt(7), res.getString(1), res.getString(2),res.getString(3), res.getString(4), res.getString(5));
				dossier = new Dossier(res.getInt("idDos"), res.getInt("idClient"), res.getString("typeProces"), res.getString("description"),client);
				statut = res.getInt("statut");
				result = new MyResult(dossier, statut);
				dossiers.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connexion.disconect();
		return dossiers;
		
	}
	
	
	
	
}




