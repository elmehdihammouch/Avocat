package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Client;
import models.Compte;

public class daoClient {
	public static ArrayList<Compte> listClient(){
		ResultSet res;
		ArrayList<Compte> clients = new ArrayList<Compte>();
		Connexion.connect();
		res=Connexion.select("select cl.* , co.idCompte, co.emailClient, co.passwordCliient , co.statut from client cl left outer join compte co ON cl.idClient = co.idClient");
		try {
			while(res.next()) {
				Client client = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getDate(4),res.getString(5), res.getString(6), res.getString(7),res.getString(8), res.getString(9), res.getString(10),res.getString(11));
				Compte compte = new Compte(res.getInt(12), res.getInt(1), res.getString(13), res.getString(14), res.getInt(15),client); 	
				clients.add(compte);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connexion.disconect();
		return clients;
		
	}
	public static Compte infclient(int idclient){
		ResultSet res;
		Connexion.connect();
		res=Connexion.select("select cl.* , co.idCompte, co.emailClient, co.passwordCliient , co.statut from client cl left outer join compte co ON cl.idClient = co.idClient where cl.idClient = "+idclient+"");
		Client client = null;
		Compte compte = null;
		try {  
			while(res.next()) {
				client = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getDate(4),res.getString(5), res.getString(6), res.getString(7),res.getString(8), res.getString(9), res.getString(10),res.getString(11));
				compte = new Compte(res.getInt(12), res.getInt(1), res.getString(13), res.getString(14), res.getInt(15),client);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connexion.disconect();
		return compte;
		
	}
	
	public static int modif(Compte client) {
		Connexion.connect();
		int nbr = Connexion.maj("UPDATE `client` left outer join compte ON compte.idClient = "+client.getClient().getId()+" "
				+ "SET `nom`='"+client.getClient().getNom().trim()+"',`prenom`='"+client.getClient().getPrenom().trim()+"',`datenais`='"+client.getClient().getDateNais()+"',"
				+ "`lieunais`='"+client.getClient().getLieuNais().trim()+"',`adresse`='"+client.getClient().getAdresse().trim()+"',`municipal`='"+client.getClient().getMunicipale().trim()+"',"
				+ "`tel`='"+client.getClient().getTelephone().trim()+"',`email`='"+client.getClient().getEmail().trim()+"',`emailClient`='"+client.getEmailCl().trim()+"',"
				+ "`passwordCliient`='"+client.getPasswordCl().trim()+"',`statut`='"+client.getStatut()+"' "
				+ "WHERE client.idClient ="+client.getClient().getId());
		Connexion.disconect();
		return nbr;
	}
	
	public static int modifier(Client client) {
		Connexion.connect();
		int nbr = Connexion.maj("UPDATE `client` SET `nom`='"+client.getNom().trim()+"',`prenom`='"+client.getPrenom().trim()+"',"
				+ "`datenais`='"+client.getDateNais()+"', `lieunais`='"+client.getLieuNais().trim()+"',`adresse`='"+client.getAdresse().trim()+"',"
				+ "`municipal`='"+client.getMunicipale().trim()+"',`tel`='"+client.getTelephone().trim()+"',`email`='"+client.getEmail().trim()+"'"
				+ " WHERE client.idClient ="+client.getId());
		Connexion.disconect();
		return nbr;
	}
	
	public static int delete(int id){
		int idProces , nbr = 0;
		ResultSet res;
		Connexion.connect();
		res=Connexion.select("select idProces from proces where idDos in (select idDos from dossier where idClient = "+id+")");
		nbr += Connexion.maj("DELETE FROM `client` WHERE idClient = "+id+"");
		nbr += Connexion.maj("DELETE FROM `dossier` WHERE idClient = "+id+"");
		nbr += Connexion.maj("DELETE FROM `compte` WHERE idClient = "+id+"");
		nbr += Connexion.maj("DELETE FROM `consultation` WHERE idClient = "+id+"");
		try {
			res.next();
			idProces = res.getInt("idProces");
			nbr += Connexion.maj("DELETE FROM `proces` WHERE idProces = "+idProces+"");			
			nbr += Connexion.maj("DELETE FROM `facture` WHERE idProces = "+idProces+"");
			nbr += Connexion.maj("DELETE FROM `piece` WHERE idProces = "+idProces+"");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return nbr;
	}
	
	
}
