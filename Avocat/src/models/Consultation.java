package models;

public class Consultation {
 
	private int idConsultation;
	private String typeProces;
	private String description;
	private int frais;
	public Consultation(int idConsultation, String typeProces, String description, int frais) {
		super();
		this.idConsultation = idConsultation;
		this.typeProces = typeProces;
		this.description = description;
		this.frais = frais;
	}
	public Consultation(String typeProces, String description, int frais) {
		super();
		this.typeProces = typeProces;
		this.description = description;
		this.frais = frais;
	}
	public Consultation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdConsultation() {
		return idConsultation;
	}
	public void setIdConsultation(int idConsultation) {
		this.idConsultation = idConsultation;
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
	public int getFrais() {
		return frais;
	}
	public void setFrais(int frais) {
		this.frais = frais;
	}
	
	
	
}
