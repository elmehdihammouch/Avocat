package models;

import tools.Date;

public class Facture {
	private int idFacture;
	private int idProces;
	private Date datePayement;
	private int indemniteKm;
	private int lgKm;
	private int prKm;
	private int prixLog;
	private int dureeJr;
	private int prixJr;
	private int mtBase;
	private int mtGlobal;
	private int mtPaye;
	
	
	public Facture() {
		super();
	}


	public Facture(Date datePayement, int prKm, int mtBase, int mtGlobal, int mtpaye) {
		super();
		this.datePayement = datePayement;
		this.prKm = prKm;
		this.mtBase = mtBase;
		this.mtGlobal = mtGlobal;
		this.mtPaye = mtpaye;
	}
	
	public Facture(int idProces, Date datePayement, int prKm, int mtBase, int mtGlobal, int mtpaye) {
		super();
		this.idProces = idProces;
		this.datePayement = datePayement;
		this.prKm = prKm;
		this.mtBase = mtBase;
		this.mtGlobal = mtGlobal;
		this.mtPaye = mtpaye;
	}


	public Facture(int idProces, Date datePayement, int indemniteKm, int lgKm, int prKm, int prixLog, int dureeJr,
			int prixJr, int mtBase, int mtGlobal, int mtpaye) {
		super();
		this.idProces = idProces;
		this.datePayement = datePayement;
		this.indemniteKm = indemniteKm;
		this.lgKm = lgKm;
		this.prKm = prKm;
		this.prixLog = prixLog;
		this.dureeJr = dureeJr;
		this.prixJr = prixJr;
		this.mtBase = mtBase;
		this.mtGlobal = mtGlobal;
		this.mtPaye = mtpaye;
	}


	public Facture(int idFacture, int idProces, Date datePayement, int indemniteKm, int lgKm, int prKm, int prixLog,
			int dureeJr, int prixJr, int mtBase, int mtGlobal, int mtpaye) {
		super();
		this.idFacture = idFacture;
		this.idProces = idProces;
		this.datePayement = datePayement;
		this.indemniteKm = indemniteKm;
		this.lgKm = lgKm;
		this.prKm = prKm;
		this.prixLog = prixLog;
		this.dureeJr = dureeJr;
		this.prixJr = prixJr;
		this.mtBase = mtBase;
		this.mtGlobal = mtGlobal;
		this.mtPaye = mtpaye;
	}

	

	public Facture(int idFacture, int mtGlobal, int mtPaye) {
		super();
		this.idFacture = idFacture;
		this.mtGlobal = mtGlobal;
		this.mtPaye = mtPaye;
	}


	public int getIdFacture() {
		return idFacture;
	}


	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}


	public int getIdProces() {
		return idProces;
	}


	public void setIdProces(int idProces) {
		this.idProces = idProces;
	}


	public Date getDatePayement() {
		return datePayement;
	}


	public void setDatePayement(Date datePayement) {
		this.datePayement = datePayement;
	}


	public int getIndemniteKm() {
		return indemniteKm;
	}


	public void setIndemniteKm(int indemniteKm) {
		this.indemniteKm = indemniteKm;
	}


	public int getLgKm() {
		return lgKm;
	}


	public void setLgKm(int lgKm) {
		this.lgKm = lgKm;
	}


	public int getPrKm() {
		return prKm;
	}


	public void setPrKm(int prKm) {
		this.prKm = prKm;
	}


	public int getPrixLog() {
		return prixLog;
	}


	public void setPrixLog(int prixLog) {
		this.prixLog = prixLog;
	}


	public int getDureeJr() {
		return dureeJr;
	}


	public void setDureeJr(int dureeJr) {
		this.dureeJr = dureeJr;
	}


	public int getPrixJr() {
		return prixJr;
	}


	public void setPrixJr(int prixJr) {
		this.prixJr = prixJr;
	}


	public int getMtBase() {
		return mtBase;
	}


	public void setMtBase(int mtBase) {
		this.mtBase = mtBase;
	}


	public int getMtGlobal() {
		return mtGlobal;
	}


	public void setMtGlobal(int mtGlobal) {
		this.mtGlobal = mtGlobal;
	}


	public int getMtpaye() {
		return mtPaye;
	}


	public void setMtpaye(int mtpaye) {
		this.mtPaye = mtpaye;
	}


	public int getMtPaye() {
		return mtPaye;
	}


	public void setMtPaye(int mtPaye) {
		this.mtPaye = mtPaye;
	}


	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", idProces=" + idProces + ", datePayement=" + datePayement
				+ ", indemniteKm=" + indemniteKm + ", lgKm=" + lgKm + ", prKm=" + prKm + ", prixLog=" + prixLog
				+ ", dureeJr=" + dureeJr + ", prixJr=" + prixJr + ", mtBase=" + mtBase + ", mtGlobal=" + mtGlobal
				+ ", mtPaye=" + mtPaye + "]";
	}
	
	
	
}
