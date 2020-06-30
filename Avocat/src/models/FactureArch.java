package models;

import tools.Date;

public class FactureArch {
	 private int idFactureArch;
	  private int idFacture;
	  private Date datePayement;
	  private Float lgKm;
	  private Float prKm;
	  private Float dureeJr;
	  private Float prixJr;
	  private Float mtPaye;
	  private Date dateModifcation;
	
	  
	  public FactureArch(int idFactureArch, int idFacture, Date datePayement, Float lgKm, Float prKm, Float dureeJr,
			Float prixJr, Float mtPaye) {
		super();
		this.idFactureArch = idFactureArch;
		this.idFacture = idFacture;
		this.datePayement = datePayement;
		this.lgKm = lgKm;
		this.prKm = prKm;
		this.dureeJr = dureeJr;
		this.prixJr = prixJr;
		this.mtPaye = mtPaye;
	}


	public FactureArch(int idFacture, Date datePayement, Float lgKm, Float prKm, Float dureeJr, Float prixJr,
			Float mtPaye) {
		super();
		this.idFacture = idFacture;
		this.datePayement = datePayement;
		this.lgKm = lgKm;
		this.prKm = prKm;
		this.dureeJr = dureeJr;
		this.prixJr = prixJr;
		this.mtPaye = mtPaye;
	}
	
	


	public FactureArch(int idFactureArch, int idFacture, Date datePayement, Float lgKm, Float prKm, Float dureeJr,
			Float prixJr, Float mtPaye, Date dateModifcation) {
		super();
		this.idFactureArch = idFactureArch;
		this.idFacture = idFacture;
		this.datePayement = datePayement;
		this.lgKm = lgKm;
		this.prKm = prKm;
		this.dureeJr = dureeJr;
		this.prixJr = prixJr;
		this.mtPaye = mtPaye;
		this.dateModifcation = dateModifcation;
	}


	public int getIdFactureArch() {
		return idFactureArch;
	}


	public void setIdFactureArch(int idFactureArch) {
		this.idFactureArch = idFactureArch;
	}


	public int getIdFacture() {
		return idFacture;
	}


	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
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


	public Float getMtPaye() {
		return mtPaye;
	}


	public void setMtPaye(Float mtPaye) {
		this.mtPaye = mtPaye;
	}


	public Date getDateModifcation() {
		return dateModifcation;
	}


	public void setDateModifcation(Date dateModifcation) {
		this.dateModifcation = dateModifcation;
	}


	@Override
	public String toString() {
		return "FactureArch [idFactureArch=" + idFactureArch + ", idFacture=" + idFacture + ", datePayement="
				+ datePayement + ", lgKm=" + lgKm + ", prKm=" + prKm + ", dureeJr=" + dureeJr + ", prixJr=" + prixJr
				+ ", mtPaye=" + mtPaye + ", dateModifcation=" + dateModifcation + "]";
	}


	
	  
	  
	  
	  
	  
	  

}
