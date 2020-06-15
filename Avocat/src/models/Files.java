package models;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

import DAO.daoFiles;

public class Files {
	private int idPiece;
	private int idProces;
	private String nomFichier;
	private String path;
	
	private final static String UPLOAD_DIRECTORY_images = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\images";
	private final static String UPLOAD_DIRECTORY_videos = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\videos";
	private final static String UPLOAD_DIRECTORY_docx = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\docx";
	private final static String UPLOAD_DIRECTORY_pdfs = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\pdfs"; 
	private final static String UPLOAD_DIRECTORY_audios = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\audios"; 
	private final static String UPLOAD_DIRECTORY_others = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\others"; 

	
	public Files() {
		super();
	}


	public Files(int idProces, String nomFichier, String path) {
		super();
		this.idProces = idProces;
		this.nomFichier = nomFichier;
		this.path = path;
	}


	public Files(String nomFichier, String path) {
		super();
		this.nomFichier = nomFichier;
		this.path = path;
	}


	public Files(int idPiece, int idProces, String nomFichier, String path) {
		super();
		this.idPiece = idPiece;
		this.idProces = idProces;
		this.nomFichier = nomFichier;
		this.path = path;
	}


	public int getIdPiece() {
		return idPiece;
	}


	public void setIdPiece(int idPiece) {
		this.idPiece = idPiece;
	}


	public int getIdProces() {
		return idProces;
	}


	public void setIdProces(int idProces) {
		this.idProces = idProces;
	}


	public String getNomFichier() {
		return nomFichier;
	}


	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	@Override
	public String toString() {
		return "Files [idPiece=" + idPiece + ", idProces=" + idProces + ", nomFichier=" + nomFichier + ", path=" + path
				+ "]";
	}


	public static ArrayList<Files> fileUpload(List<Part> files){
		//filesList : arraylist des files (fileList) qui seront construit a partir des part (file) arrivons de ma list files
		ArrayList<Files> filesList = new ArrayList<Files>();
		String fileName ;
		String nameWithOutExtension ; 
		String extension ;
		for (Part file : files) {
	       fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	       nameWithOutExtension = FilenameUtils.removeExtension(fileName)+(daoFiles.maxId()+1);
	       extension = FilenameUtils.getExtension(fileName);
	       fileName = nameWithOutExtension+"."+extension;
	       Files fileList=new Files(fileName, UPLOAD_DIRECTORY_images + File.separator + fileName);
	       filesList.add(fileList);
	       
	       if(FilenameUtils.getExtension(fileName).equals("png") || FilenameUtils.getExtension(fileName).equals("jpeg") || FilenameUtils.getExtension(fileName).equals("jpg")) {
		       try {
					file.write(UPLOAD_DIRECTORY_images + File.separator + fileName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("erreur lors de l'upload du "+fileName);
				}
	       }
	       
	       else if (FilenameUtils.getExtension(fileName).equals("mp4")) {
	    	   try {
					file.write(UPLOAD_DIRECTORY_videos + File.separator + fileName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("erreur lors de l'upload du "+fileName);
				}
	       }
	       
	       else if (FilenameUtils.getExtension(fileName).equals("mp3")) {
	    	   try {
					file.write(UPLOAD_DIRECTORY_audios + File.separator + fileName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("erreur lors de l'upload du "+fileName);
				}
	       }
	       
	       else if (FilenameUtils.getExtension(fileName).equals("pdf")) {
	    	   try {
					file.write(UPLOAD_DIRECTORY_pdfs + File.separator + fileName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("erreur lors de l'upload du "+fileName);
				}
	       }
	       
	       else if (FilenameUtils.getExtension(fileName).equals("docx") || FilenameUtils.getExtension(fileName).equals("doc") || FilenameUtils.getExtension(fileName).equals("txt")) {
	    	   try {
					file.write(UPLOAD_DIRECTORY_docx + File.separator + fileName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("erreur lors de l'upload du "+fileName);
				}
	       }
	       else {
	    	   try {
					file.write(UPLOAD_DIRECTORY_others + File.separator + fileName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("erreur lors de l'upload du "+fileName);
				}
	       }
	        
	        
	    }
		return filesList;
		
		
	}
	
	
}
