package models;

public class Dossier {
	public  int idDos;
	public int idClient;
	public int etatAv;
	public String typeProces;
	public String description;
	
	
	public Dossier() {
		super();
	}

	public Dossier(int etatAv, String typeProces, String description) {
		super();
		this.etatAv = etatAv;
		this.typeProces = typeProces;
		this.description = description;
	}
	public Dossier(int idClient, int etatAv, String typeProces, String description) {
		super();
		this.idClient = idClient;
		this.etatAv = etatAv;
		this.typeProces = typeProces;
		this.description = description;
	}
	
	public Dossier(int idDos, int idClient, int etatAv, String typeProces, String description) {
		super();
		this.idDos = idDos;
		this.idClient = idClient;
		this.etatAv = etatAv;
		this.typeProces = typeProces;
		this.description = description;
	}


	public int getIdDos() {
		return idDos;
	}


	public void setIdDos(int idDos) {
		this.idDos = idDos;
	}


	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


	public int getEtatAv() {
		return etatAv;
	}


	public void setEtatAv(int etatAv) {
		this.etatAv = etatAv;
	}


	public String getTypeProces() {
		return typeProces;
	}


	public void setTypeProces(String typeProces) {
		this.typeProces = typeProces;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Dossier [idDos=" + idDos + ", idClient=" + idClient + ", etatAv=" + etatAv + ", typeProces="
				+ typeProces + ", description=" + description + "]";
	}
	
	
	
	
	
}
