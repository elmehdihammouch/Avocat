package models;

import java.sql.Date;

public class Administrateur {
	private int id;
	private String nom;
	private String prenom;
	private Date dateNais;
	private String lieuNais;
	private String nationalite;
	private String cin;
	private String email;
	private String password;
	private String imageUrl;
	
	public Administrateur(int id, String nom, String prenom, Date dateNais, String lieuNais, String nationalite,
			String cin, String email, String password, String imageUrl) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNais = dateNais;
		this.lieuNais = lieuNais;
		this.nationalite = nationalite;
		this.cin = cin;
		this.email = email;
		this.password = password;
		this.imageUrl = imageUrl;
	}

	public Administrateur(String nom, String prenom, Date dateNais, String lieuNais, String nationalite, String cin,
			String email, String password, String imageUrl) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNais = dateNais;
		this.lieuNais = lieuNais;
		this.nationalite = nationalite;
		this.cin = cin;
		this.email = email;
		this.password = password;
		this.imageUrl = imageUrl;
	}
	
	

	public Administrateur() {
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

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
	
	
	
	
	
	

}
