package DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Client;
import models.Compte;

public class daoClient {
	public static ArrayList<Client> dossierClient(){
		ResultSet res;
		ArrayList<Client> clients = new ArrayList<Client>();
		Connexion.connect();
		res=Connexion.select("select cl.* , co.idCompte, co.emailClient, co.passwordCliient , co.statut from client cl left outer join compte co ON cl.idClient = co.idClient");
		try {
			while(res.next()) {
				Compte compte = new Compte(res.getInt(12), res.getInt(1), res.getString(13), res.getString(14), res.getInt(15)); 
				Client client = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getDate(4),res.getString(5), res.getString(6), res.getString(7),res.getString(8), res.getString(9), res.getString(10),res.getString(11),compte);
				clients.add(client);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connexion.disconect();
		return clients;
		
	}
}
