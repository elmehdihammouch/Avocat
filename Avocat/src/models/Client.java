package models;

import java.sql.Date;

public class Client {
	public int id;
	public String nom;
	public String prenom;
	public Date dateNais;
	public String lieuNais;
	public String nationalite;
	public String adresse;
	public String cin;
	public String municipale;
	public String telephone;
	public String email;
	public String password;
	public String typeServ;
	
	
	public Client(int id, String nom, String prenom, Date dateNais, String lieuNais, String nationalite, String adresse,
			String cin, String municipale, String telephone, String email, String password, String typeServ) {
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
		this.typeServ = typeServ;
	}


	public Client(String nom, String prenom, Date dateNais, String lieuNais, String nationalite, String adresse,
			String cin, String municipale, String telephone, String email, String password, String typeServ) {
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
		this.typeServ = typeServ;
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


	public String getTypeServ() {
		return typeServ;
	}


	public void setTypeServ(String typeServ) {
		this.typeServ = typeServ;
	}


	





}
