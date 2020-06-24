package models;

import tools.Date;

public class Facture {
	  private int idFacture;
	  private int idProces;
	  private Date datePayement;
	  private Float indemniteKm;
	  private Float lgKm;
	  private Float prKm;
	  private Float prixLog;
	  private Float dureeJr;
	  private Float prixJr;
	  private Float mtBase;
	  private Float mtGlobal;
	  private Float mtPaye;
	
	
	public Facture() {
		super();
	}


	public Facture(Date datePayement, Float mtBase, Float mtGlobal, Float mtpaye) {
		super();
		this.datePayement = datePayement;
		this.mtBase = mtBase;
		this.mtGlobal = mtGlobal;
		this.mtPaye = mtpaye;
	}
	
	public Facture(int idProces, Date datePayement, Float prKm, Float mtBase, Float mtGlobal, Float mtpaye) {
		super();
		this.idProces = idProces;
		this.datePayement = datePayement;
		this.prKm = prKm;
		this.mtBase = mtBase;
		this.mtGlobal = mtGlobal;
		this.mtPaye = mtpaye;
	}


	public Facture(int idProces, Date datePayement, Float indemniteKm, Float lgKm, Float prKm, Float prixLog, Float dureeJr,
			Float prixJr, Float mtBase, Float mtGlobal, Float mtpaye) {
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


	public Facture(int idFacture, int idProces, Date datePayement, Float indemniteKm, Float lgKm, Float prKm, Float prixLog,
			Float dureeJr, Float prixJr, Float mtBase, Float mtGlobal, Float mtpaye) {
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

	

	public Facture(int idFacture, Float mtGlobal, Float mtPaye) {
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


	public Float getIndemniteKm() {
		return indemniteKm;
	}


	public void setIndemniteKm(Float indemniteKm) {
		this.indemniteKm = indemniteKm;
	}


	public Float getLgKm() {
		return lgKm;
	}


	public void setLgKm(Float lgKm) {
		this.lgKm = lgKm;
	}


	public Float getPrKm() {
		return prKm;
	}


	public void setPrKm(Float prKm) {
		this.prKm = prKm;
	}


	public Float getPrixLog() {
		return prixLog;
	}


	public void setPrixLog(Float prixLog) {
		this.prixLog = prixLog;
	}


	public Float getDureeJr() {
		return dureeJr;
	}


	public void setDureeJr(Float dureeJr) {
		this.dureeJr = dureeJr;
	}


	public Float getPrixJr() {
		return prixJr;
	}


	public void setPrixJr(Float prixJr) {
		this.prixJr = prixJr;
	}


	public Float getMtBase() {
		return mtBase;
	}


	public void setMtBase(Float mtBase) {
		this.mtBase = mtBase;
	}


	public Float getMtGlobal() {
		return mtGlobal;
	}


	public void setMtGlobal(Float mtGlobal) {
		this.mtGlobal = mtGlobal;
	}


	public Float getMtpaye() {
		return mtPaye;
	}


	public void setMtpaye(Float mtpaye) {
		this.mtPaye = mtpaye;
	}


	public Float getMtPaye() {
		return mtPaye;
	}


	public void setMtPaye(Float mtPaye) {
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
