package models;

import java.lang.reflect.Field;
import java.util.ArrayList;

import tools.Date;

public class ProcesArch {
	private int idProcesArch;
	private int idProces;						//dateCP; statut;numP;cinAdv;dateAP
	private String description;					//dateNotif;description;
	private String adresseAdv;
	private String nomAdv;
	private String prenomAdv;
	private String avocatAdv;
	private String tribunal;
	private String ville;
	private String saleNum;
	private Date dateSeance;
	private Date dateSui;
	private String txtJug;
	private Date dateJug;
	private Date dateNotif;
	private Date dateModification;
	
	
	public ProcesArch(int idProcesArch, int idProces, String description, String adresseAdv, String nomAdv,
			String prenomAdv, String avocatAdv, String tribunal, String ville, String saleNum, Date dateSeance,
			Date dateSui, String txtJug, Date dateJug, Date dateNotif) {
		super();
		this.idProcesArch = idProcesArch;
		this.idProces = idProces;
		this.description = description;
		this.adresseAdv = adresseAdv;
		this.nomAdv = nomAdv;
		this.prenomAdv = prenomAdv;
		this.avocatAdv = avocatAdv;
		this.tribunal = tribunal;
		this.ville = ville;
		this.saleNum = saleNum;
		this.dateSeance = dateSeance;
		this.dateSui = dateSui;
		this.txtJug = txtJug;
		this.dateJug = dateJug;
		this.dateNotif = dateNotif;
	}


	public ProcesArch(int idProces, String description, String adresseAdv, String nomAdv, String prenomAdv,
			String avocatAdv, String tribunal, String ville, String saleNum, Date dateSeance, Date dateSui,
			String txtJug, Date dateJug, Date dateNotif) {
		super();
		this.idProces = idProces;
		this.description = description;
		this.adresseAdv = adresseAdv;
		this.nomAdv = nomAdv;
		this.prenomAdv = prenomAdv;
		this.avocatAdv = avocatAdv;
		this.tribunal = tribunal;
		this.ville = ville;
		this.saleNum = saleNum;
		this.dateSeance = dateSeance;
		this.dateSui = dateSui;
		this.txtJug = txtJug;
		this.dateJug = dateJug;
		this.dateNotif = dateNotif;
	}

	
	

	public ProcesArch(int idProcesArch, int idProces, String description, String adresseAdv, String nomAdv,
			String prenomAdv, String avocatAdv, String tribunal, String ville, String saleNum, Date dateSeance,
			Date dateSui, String txtJug, Date dateJug, Date dateNotif, Date dateModification) {
		super();
		this.idProcesArch = idProcesArch;
		this.idProces = idProces;
		this.description = description;
		this.adresseAdv = adresseAdv;
		this.nomAdv = nomAdv;
		this.prenomAdv = prenomAdv;
		this.avocatAdv = avocatAdv;
		this.tribunal = tribunal;
		this.ville = ville;
		this.saleNum = saleNum;
		this.dateSeance = dateSeance;
		this.dateSui = dateSui;
		this.txtJug = txtJug;
		this.dateJug = dateJug;
		this.dateNotif = dateNotif;
		this.dateModification = dateModification;
	}


	public int getIdProcesArch() {
		return idProcesArch;
	}


	public void setIdProcesArch(int idProcesArch) {
		this.idProcesArch = idProcesArch;
	}


	public int getIdProces() {
		return idProces;
	}


	public void setIdProces(int idProces) {
		this.idProces = idProces;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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


	public String getPrenomAdv() {
		return prenomAdv;
	}


	public void setPrenomAdv(String prenomAdv) {
		this.prenomAdv = prenomAdv;
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


	public String getSaleNum() {
		return saleNum;
	}


	public void setSaleNum(String saleNum) {
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


	public Date getDateNotif() {
		return dateNotif;
	}


	public void setDateNotif(Date dateNotif) {
		this.dateNotif = dateNotif;
	}
	
	
	
	
	public Date getDateModification() {
		return dateModification;
	}


	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}


	@SuppressWarnings("unlikely-arg-type")
	public static ProcesArch procesArchCheck(ProcesArch p) {
		Field[] fields = ProcesArch.class.getDeclaredFields();
		for(Field f : fields) {
			try {
				if(f.get(p) instanceof String) {
					if(f.get(p).equals("")) {System.out.println(f+" "+f.get(p)+" 2");f.set(p, null);}
					else  {f.set(p, "'"+f.get(p)+"'");}
				}
				else if (f.equals("idProces") || f.equals("statut") || f.equals("idProcesArch")) {
					if( f.get(p).equals("")) {f.set(p,0);}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
		
	}
	
	
	
	
	
	
	













}

