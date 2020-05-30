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

public class Files {
	public int idPiece;
	public int idProces;
	public String nomFichier;
	public String path;
	
	private final static String UPLOAD_DIRECTORY_images = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\images";
	private final static String UPLOAD_DIRECTORY_videos = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\videos";
	private final static String UPLOAD_DIRECTORY_docx = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\docx";
	private final static String UPLOAD_DIRECTORY_pdfs = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\pdfs"; 
	private final static String UPLOAD_DIRECTORY_audios = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\audios"; 
	
	
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
		
		for (Part file : files) {
	       String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
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
	        
	        
	    }
		return filesList;
		
		
	}
	
	
}
