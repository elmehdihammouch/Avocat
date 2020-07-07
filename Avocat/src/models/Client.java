package models;

import java.sql.Date;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private Date dateNais;
	private String lieuNais;
	private String nationalite;
	private String adresse;
	private String cin;
	private String municipale;
	private String telephone;
	private String email;
	private String password;
	
	
	
	
	
	


	public Client(int id, String nom, String prenom, String cin, String telephone, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.telephone = telephone;
		this.email = email;
	}


	public Client(int id, String nom, String prenom, Date dateNais, String lieuNais, String nationalite, String adresse,
			String cin, String municipale, String telephone, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNais = dateNais;
		this.lieuNais = lieuNais;
		this.nationalite = nationalite;
		this.adresse = adresse;
		this.cin = cin;
		this.municipale = municipale;
		this.telephone = telephone;
		this.email = email;

	}


	public Client(int id, String nom, String prenom, Date dateNais, String lieuNais, String adresse, String municipale,
			String telephone, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNais = dateNais;
		this.lieuNais = lieuNais;
		this.adresse = adresse;
		this.municipale = municipale;
		this.telephone = telephone;
		this.email = email;
	}




	public Client(int id, String nom, String prenom, Date dateNais, String lieuNais, String nationalite, String adresse,
			String cin, String municipale, String telephone, String email, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNais = dateNais;
		this.lieuNais = lieuNais;
		this.nationalite = nationalite;
		this.adresse = adresse;
		this.cin = cin;
		this.municipale = municipale;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
	
	}


	public Client(String nom, String prenom, Date dateNais, String lieuNais, String nationalite, String adresse,
			String cin, String municipale, String telephone, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNais = dateNais;
		this.lieuNais = lieuNais;
		this.nationalite = nationalite;
		this.adresse = adresse;
		this.cin = cin;
		this.municipale = municipale;
		this.telephone = telephone;
		this.email = email;
	}


	public Client(String nom, String prenom, Date dateNais, String lieuNais, String nationalite, String adresse,
			String cin, String municipale, String telephone, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNais = dateNais;
		this.lieuNais = lieuNais;
		this.nationalite = nationalite;
		this.adresse = adresse;
		this.cin = cin;
		this.municipale = municipale;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
		
	}


	public Client() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Date getDateNais() {
		return dateNais;
	}


	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}


	public String getLieuNais() {
		return lieuNais;
	}


	public void setLieuNais(String lieuNais) {
		this.lieuNais = lieuNais;
	}


	public String getNationalite() {
		return nationalite;
	}


	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getMunicipale() {
		return municipale;
	}


	public void setMunicipale(String municipale) {
		this.municipale = municipale;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}




	


	





}
