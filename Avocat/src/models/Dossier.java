package models;

public class Dossier {
	private int idDos;
	private int idClient;
	private String typeProces;
	private String description;
	
	
	public Dossier() {
		super();
	}

	public Dossier(String typeProces, String description) {
		super();
		this.typeProces = typeProces;
		this.description = description;
	}
	public Dossier(int idClient, String typeProces, String description) {
		super();
		this.idClient = idClient;
		this.typeProces = typeProces;
		this.description = description;
	}
	
	public Dossier(int idDos, int idClient, String typeProces, String description) {
		super();
		this.idDos = idDos;
		this.idClient = idClient;
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
		return "Dossier [idDos=" + idDos + ", idClient=" + idClient + ", typeProces="
				+ typeProces + ", description=" + description + "]";
	}
	
	
	
	
	
}
