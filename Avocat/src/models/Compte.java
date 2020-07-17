package models;

public class Compte {
	private int idCompte;
	private int	idClient;
	private String emailCl;
	private String passwordCl;
	private int statut;
	private Client client;
	public Compte(int idCompte, int idClient, String emailCl, String passwordCl, int statut) {
		super();
		this.idCompte = idCompte;
		this.idClient = idClient;
		this.emailCl = emailCl;
		this.passwordCl = passwordCl;
		this.statut = statut;
	}
	
	public Compte() {
		super();
	}

	public Compte(int idClient, String emailCl, String passwordCl, int statut, Client client) {
		super();
		this.idClient = idClient;
		this.emailCl = emailCl;
		this.passwordCl = passwordCl;
		this.statut = statut;
		this.client = client;
	}

	public Compte(int idCompte, int idClient, String emailCl, String passwordCl, int statut, Client client) {
		super();
		this.idCompte = idCompte;
		this.idClient = idClient;
		this.emailCl = emailCl;
		this.passwordCl = passwordCl;
		this.statut = statut;
		this.client = client;
	}

	public Compte(int idClient, String emailCl, String passwordCl, int statut) {
		super();
		this.idClient = idClient;
		this.emailCl = emailCl;
		this.passwordCl = passwordCl;
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Compte [idCompte=" + idCompte + ", idClient=" + idClient + ", emailCl=" + emailCl + ", passwordCl="
				+ passwordCl + ", statut=" + statut + "]";
	}
	public int getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getEmailCl() {
		return emailCl;
	}
	public void setEmailCl(String emailCl) {
		this.emailCl = emailCl;
	}
	public String getPasswordCl() {
		return passwordCl;
	}
	public void setPasswordCl(String passwordCl) {
		this.passwordCl = passwordCl;
	}
	public int getStatut() {
		return statut;
	}
	public void setStatut(int statut) {
		this.statut = statut;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
