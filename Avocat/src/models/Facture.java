package models;

import tools.Date;

public class Facture {
	  private int idFacture;
	  private int idProces;
	  private Date datePayement;
	  private Float lgKm;
	  private Float prKm;
	  private Float dureeJr;
	  private Float prixJr;
	  private Float mtBase;
	  private Float mtGlobal;
	  private Float mtPaye;
	  private Float mtPayeAjoute;
	
	
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


	public Facture(int idProces, Date datePayement, Float lgKm, Float prKm, Float dureeJr,
			Float prixJr, Float mtBase, Float mtGlobal, Float mtpaye) {
		super();
		this.idProces = idProces;
		this.datePayement = datePayement;
		this.lgKm = lgKm;
		this.prKm = prKm;
		this.dureeJr = dureeJr;
		this.prixJr = prixJr;
		this.mtBase = mtBase;
		this.mtGlobal = mtGlobal;
		this.mtPaye = mtpaye;
	}


	public Facture(int idFacture, int idProces, Date datePayement, Float lgKm, Float prKm,
			Float dureeJr, Float prixJr, Float mtBase, Float mtGlobal, Float mtpaye, Float mtpayeajoute) {
		super();
		this.idFacture = idFacture;
		this.idProces = idProces;
		this.datePayement = datePayement;
		this.lgKm = lgKm;
		this.prKm = prKm;
		this.dureeJr = dureeJr;
		this.prixJr = prixJr;
		this.mtBase = mtBase;
		this.mtGlobal = mtGlobal;
		this.mtPaye = mtpaye;
		this.mtPayeAjoute = mtpayeajoute;
		
	}
	
	public Facture( int idProces, Date datePayement, Float lgKm, Float prKm,
			Float dureeJr, Float prixJr, Float mtBase, Float mtGlobal, Float mtpaye, Float mtpayeajoute) {
		super();
		this.idProces = idProces;
		this.datePayement = datePayement;
		this.lgKm = lgKm;
		this.prKm = prKm;
		this.dureeJr = dureeJr;
		this.prixJr = prixJr;
		this.mtBase = mtBase;
		this.mtPaye = mtpaye;
		this.mtPayeAjoute = mtpayeajoute;
		
	}
	
	public Facture(int idFacture, int idProces, Date datePayement, Float mtBase, Float mtGlobal, Float mtpaye) {
		super();
		this.idFacture = idFacture;
		this.idProces = idProces;
		this.datePayement = datePayement;
		this.mtBase = mtBase;
		this.mtGlobal = mtGlobal;
		this.mtPaye = mtpaye;
	}
	
	public Facture(int idProces, Date datePayement, Float lgKm, Float prKm,
			Float dureeJr, Float prixJr, Float mtBase, Float mtpaye) {
		super();
		this.idProces = idProces;
		this.datePayement = datePayement;
		this.lgKm = lgKm;
		this.prKm = prKm;
		this.dureeJr = dureeJr;
		this.prixJr = prixJr;
		this.mtBase = mtBase;
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
	


	public Float getMtPayeAjoute() {
		return mtPayeAjoute;
	}


	public void setMtPayeAjoute(Float mtPayeAjoute) {
		this.mtPayeAjoute = mtPayeAjoute;
	}


	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", idProces=" + idProces + ", datePayement=" + datePayement
				+ ", lgKm=" + lgKm + ", prKm=" + prKm + ", dureeJr=" + dureeJr + ", prixJr=" + prixJr + ", mtBase="
				+ mtBase + ", mtGlobal=" + mtGlobal + ", mtPaye=" + mtPaye + ", mtPayeAjoute=" + mtPayeAjoute + "]";
	}


	
	
	
	
}
