package models;


import java.lang.reflect.Field;
import java.util.ArrayList;


import tools.Date;

public class Proces {
	private int idProces;
	private int idDos;
	private String numP;
	private Date dateCP;
	private Date dateAP;
	private String description;
	private String adresseAdv;
	private String cinAdv;
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
	private  ArrayList<Files> files;
	private Facture facture;
	private Date dateNotif;
	private int statut;
	
	
	public Proces() {
		super();
	}
	
	//constructor of procesArch
	public Proces(int idProces, String adresseAdv, String nomAdv, String prenomAdv, String avocatAdv, String tribunal,
			String ville, String saleNum, Date dateSeance, Date dateSui, String txtJug, Date dateJug) {
		super();
		this.idProces = idProces;
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
	}
	
	
	

	public Proces(int idProces, String numP, Date dateAP, String description, String adresseAdv,
			String cinAdv, String nomAdv, String prenomAdv, String avocatAdv, String tribunal, String ville,
			String saleNum, Date dateSeance, Date dateSui, String txtJug, Date dateJug, Date dateNotif) {
		super();
		this.idProces = idProces;
		this.numP = numP;
		this.dateAP = dateAP;
		this.description = description;
		this.adresseAdv = adresseAdv;
		this.cinAdv = cinAdv;
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
		this.statut = statut;
	}



	

	public Proces(int idDos, String description, String adresseAdv, String cinAdv, String nomAdv, String prenomAdv,
			String avocatAdv, ArrayList<Files> files, Facture facture,Date dateNotif, int statut) {
		super();
		this.idDos = idDos;
		this.description = description;
		this.adresseAdv = adresseAdv;
		this.cinAdv = cinAdv;
		this.nomAdv = nomAdv;
		this.prenomAdv = prenomAdv;
		this.avocatAdv = avocatAdv;
		this.files = files;
		this.facture = facture;
		this.dateNotif = dateNotif;
		this.statut = statut;
	}

	public Proces(int idDos, String numP, Date dateCP, Date dateAP, String description, String adresseAdv, String cinAdv,
			String nomAdv, String prenomAdv, String avocatAdv, String tribunal, String ville, String saleNum,
			Date dateSeance, Date dateSui, String txtJug, Date dateJug, ArrayList<Files> files, Facture facture,Date dateNotif, int statut) {
		super();
		this.idDos = idDos;
		this.numP = numP;
		this.dateCP = dateCP;
		this.dateAP = dateAP;
		this.description = description;
		this.adresseAdv = adresseAdv;
		this.cinAdv = cinAdv;
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
		this.files = files;
		this.facture = facture;
		this.dateNotif = dateNotif;
		this.statut = statut;
	}
	
	
	
	public Proces(int idProces, int idDos, String numP, Date dateCP, Date dateAP, String description, String adresseAdv,
			String cinAdv, String nomAdv, String prenomAdv, String avocatAdv, String tribunal, String ville,
			String saleNum, Date dateSeance, Date dateSui, String txtJug, Date dateJug, 
			Facture facture,Date dateNotif, int statut) {
		super();
		this.idProces = idProces;
		this.idDos = idDos;
		this.numP = numP;
		this.dateCP = dateCP;
		this.dateAP = dateAP;
		this.description = description;
		this.adresseAdv = adresseAdv;
		this.cinAdv = cinAdv;
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
		this.facture = facture;
		this.dateNotif = dateNotif;
		this.statut = statut;
	}
	
	

	public Proces(int idProces, int idDos, String numP, Date dateCP, Date dateAP, String description, String adresseAdv,
			String cinAdv, String nomAdv, String prenomAdv, String avocatAdv, String tribunal, String ville,
			String saleNum, Date dateSeance, Date dateSui, String txtJug, Date dateJug, ArrayList<Files> files,
			Facture facture,Date dateNotif, int statut) {
		super();
		this.idProces = idProces;
		this.idDos = idDos;
		this.numP = numP;
		this.dateCP = dateCP;
		this.dateAP = dateAP;
		this.description = description;
		this.adresseAdv = adresseAdv;
		this.cinAdv = cinAdv;
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
		this.files = files;
		this.facture = facture;
		this.dateNotif = dateNotif;
		this.statut = statut;
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

	public String getNumP() {
		return numP;
	}

	public void setNumP(String numP) {
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

	public String getCinAdv() {
		return cinAdv;
	}

	public void setCinAdv(String cinAdv) {
		this.cinAdv = cinAdv;
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

	public ArrayList<Files> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<Files> files) {
		this.files = files;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Date getDateNotif() {
		return dateNotif;
	}

	public void setDateNotif(Date dateNotif) {
		this.dateNotif = dateNotif;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Proces [idProces=" + idProces + ", idDos=" + idDos + ", numP=" + numP + ", dateCP=" + dateCP
				+ ", dateAP=" + dateAP + ", description=" + description + ", adresseAdv=" + adresseAdv + ", cinAdv="
				+ cinAdv + ", nomAdv=" + nomAdv + ", prenomAdv=" + prenomAdv + ", avocatAdv=" + avocatAdv
				+ ", tribunal=" + tribunal + ", ville=" + ville + ", saleNum=" + saleNum + ", dateSeance=" + dateSeance
				+ ", dateSui=" + dateSui + ", txtJug=" + txtJug + ", dateJug=" + dateJug + ", files=" + files
				+ ", facture=" + facture + ", dateNotif=" + dateNotif + ", statut=" + statut + "]";
	}

	
public static String statutProces(Proces p) {
	String statut;
	if(p.getStatut()==1) {
		statut = "premiere instance";
	}
	else if(p.getStatut()==2) {
		statut = "deuxieme instance";
	}
	else  {
		statut = "troisième instance";
}
	return statut;
}


@SuppressWarnings("unlikely-arg-type")
public static Proces procesCheck(Proces p) {
	Field[] fields = Proces.class.getDeclaredFields();
	for(Field f : fields) {
		try {
			if(f.get(p) instanceof String) {
				if(f.get(p).equals("")) {System.out.println(f+" "+f.get(p)+" 2");f.set(p, null);System.out.println(f+" after "+f.get(p)+" 2");}
				else  {f.set(p, "'"+f.get(p)+"'");}
			}
			else if (f.equals("idProces") || f.equals("statut")) {
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
