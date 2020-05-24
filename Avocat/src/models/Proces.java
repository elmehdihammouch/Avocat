package models;

import java.sql.Date;

public class Proces {
	public int idProces;
	public int idDos;
	public int numP;
	public Date dateCP;
	public Date dateAP;
	public String adresseAdv;
	public String nomAdv;
	public String avocatAdv;
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

	public Proces(int idDos, int numP, Date dateCP, Date dateAP, String adresseAdv, String nomAdv, String avocatAdv,
			String tribunal, String ville, int saleNum, Date dateSeance, Date dateSui, String txtJug, Date dateJug) {
		super();
		this.idDos = idDos;
		this.numP = numP;
		this.dateCP = dateCP;
		this.dateAP = dateAP;
		this.adresseAdv = adresseAdv;
		this.nomAdv = nomAdv;
		this.avocatAdv = avocatAdv;
		this.tribunal = tribunal;
		this.ville = ville;
		this.saleNum = saleNum;
		this.dateSeance = dateSeance;
		this.dateSui = dateSui;
		this.txtJug = txtJug;
		this.dateJug = dateJug;
	}

	public Proces(int idProces, int idDos, int numP, Date dateCP, Date dateAP, String adresseAdv, String nomAdv,
			String avocatAdv, String tribunal, String ville, int saleNum, Date dateSeance, Date dateSui, String txtJug,
			Date dateJug) {
		super();
		this.idProces = idProces;
		this.idDos = idDos;
		this.numP = numP;
		this.dateCP = dateCP;
		this.dateAP = dateAP;
		this.adresseAdv = adresseAdv;
		this.nomAdv = nomAdv;
		this.avocatAdv = avocatAdv;
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

	public Date getDateCP() {
		return dateCP;
	}

	public void setDateCP(Date dateCP) {
		this.dateCP = dateCP;
	}

	public Date getDateAP() {
		return dateAP;
	}

	public void setDateAP(Date dateAP) {
		this.dateAP = dateAP;
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
