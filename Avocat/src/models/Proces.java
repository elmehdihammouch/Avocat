package models;

import java.sql.Date;

public class Proces {
	public int idProces;
	public int idDos;
	public int numP;
	public Date dateCD;
	public Date dateAD;
	public String adresseAdv;
	public String nomAdv;
	public String avocatAdv;
	public String typeDos;
	public String tribunal;
	public String ville;
	public int saleNum;
	public Date dateSeance;
	public Date dateSui;
	public String txtJug;
	public Date dateJug;
	
	public Proces() {
		super();
	}

	public Proces(int idDos, int numP, Date dateCD, Date dateAD, String adresseAdv, String nomAdv, String avocatAdv,
			String typeDos, String tribunal, String ville, int saleNum, Date dateSeance, Date dateSui, String txtJug,
			Date dateJug) {
		super();
		this.idDos = idDos;
		this.numP = numP;
		this.dateCD = dateCD;
		this.dateAD = dateAD;
		this.adresseAdv = adresseAdv;
		this.nomAdv = nomAdv;
		this.avocatAdv = avocatAdv;
		this.typeDos = typeDos;
		this.tribunal = tribunal;
		this.ville = ville;
		this.saleNum = saleNum;
		this.dateSeance = dateSeance;
		this.dateSui = dateSui;
		this.txtJug = txtJug;
		this.dateJug = dateJug;
	}

	public Proces(int idProces, int idDos, int numP, Date dateCD, Date dateAD, String adresseAdv, String nomAdv,
			String avocatAdv, String typeDos, String tribunal, String ville, int saleNum, Date dateSeance, Date dateSui,
			String txtJug, Date dateJug) {
		super();
		this.idProces = idProces;
		this.idDos = idDos;
		this.numP = numP;
		this.dateCD = dateCD;
		this.dateAD = dateAD;
		this.adresseAdv = adresseAdv;
		this.nomAdv = nomAdv;
		this.avocatAdv = avocatAdv;
		this.typeDos = typeDos;
		this.tribunal = tribunal;
		this.ville = ville;
		this.saleNum = saleNum;
		this.dateSeance = dateSeance;
		this.dateSui = dateSui;
		this.txtJug = txtJug;
		this.dateJug = dateJug;
	}

	public int getIdProces() {
		return idProces;
	}

	public void setIdProces(int idProces) {
		this.idProces = idProces;
	}

	public int getIdDos() {
		return idDos;
	}

	public void setIdDos(int idDos) {
		this.idDos = idDos;
	}

	public int getNumP() {
		return numP;
	}

	public void setNumP(int numP) {
		this.numP = numP;
	}

	public Date getDateCD() {
		return dateCD;
	}

	public void setDateCD(Date dateCD) {
		this.dateCD = dateCD;
	}

	public Date getDateAD() {
		return dateAD;
	}

	public void setDateAD(Date dateAD) {
		this.dateAD = dateAD;
	}

	public String getAdresseAdv() {
		return adresseAdv;
	}

	public void setAdresseAdv(String adresseAdv) {
		this.adresseAdv = adresseAdv;
	}

	public String getNomAdv() {
		return nomAdv;
	}

	public void setNomAdv(String nomAdv) {
		this.nomAdv = nomAdv;
	}

	public String getAvocatAdv() {
		return avocatAdv;
	}

	public void setAvocatAdv(String avocatAdv) {
		this.avocatAdv = avocatAdv;
	}

	public String getTypeDos() {
		return typeDos;
	}

	public void setTypeDos(String typeDos) {
		this.typeDos = typeDos;
	}

	public String getTribunal() {
		return tribunal;
	}

	public void setTribunal(String tribunal) {
		this.tribunal = tribunal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}

	public Date getDateSeance() {
		return dateSeance;
	}

	public void setDateSeance(Date dateSeance) {
		this.dateSeance = dateSeance;
	}

	public Date getDateSui() {
		return dateSui;
	}

	public void setDateSui(Date dateSui) {
		this.dateSui = dateSui;
	}

	public String getTxtJug() {
		return txtJug;
	}

	public void setTxtJug(String txtJug) {
		this.txtJug = txtJug;
	}

	public Date getDateJug() {
		return dateJug;
	}

	public void setDateJug(Date dateJug) {
		this.dateJug = dateJug;
	}
	
	
	
	
	
}
