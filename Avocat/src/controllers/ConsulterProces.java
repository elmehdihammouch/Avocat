package controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.daoAjouterProces;
import models.Facture;
import models.FactureArch;
import models.Files;
import models.Proces;
import tools.Date;
import tools.TypeChecker;

/**
 * Servlet implementation class ConsulterProces
 */
@WebServlet("/ConsulterProces")
@MultipartConfig
public class ConsulterProces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			if(action.equals("fileDownload")) {
				String filename=null;
				String filepath = null;
		
				try
				{
				    filename = request.getParameter("filename");        
		
				    if(filename == null || filename.equals(""))
				    {
				        throw new ServletException("File Name can't be null or empty");
				    }
				    //gestion des extensions
				    if(FilenameUtils.getExtension(filename).equals("png") || FilenameUtils.getExtension(filename).equals("jpeg") || FilenameUtils.getExtension(filename).equals("jpg")) {
				    filepath = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\images\\"+filename;   //change your directory path
				    }
				    
				    else if(FilenameUtils.getExtension(filename).equals("mp3")) {
					    filepath = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\audios\\"+filename;   //change your directory path
					    }
				    
				    else if(FilenameUtils.getExtension(filename).equals("mp4")) {
					    filepath = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\videos\\"+filename;   //change your directory path
					    }
				    
				    else if(FilenameUtils.getExtension(filename).equals("pdf")) {
					    filepath = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\pdfs\\"+filename;   //change your directory path
					    }
				    
				    else if(FilenameUtils.getExtension(filename).equals("docx") || FilenameUtils.getExtension(filename).equals("doc") || FilenameUtils.getExtension(filename).equals("txt")) {
					    filepath = "C:\\Users\\Leopard\\git\\Avocat\\Avocat\\WebContent\\resources\\media\\docx\\"+filename;   //change your directory path
					    }
				    
				    //-----------------------
				    File file = new File(filepath);
				    if(!file.exists())
				    {
				        throw new ServletException("File doesn't exists on server.");
				    }
				    //setting the content type of each file
				    if(FilenameUtils.getExtension(filename).equals("png") || FilenameUtils.getExtension(filename).equals("jpeg") || FilenameUtils.getExtension(filename).equals("jpg")) {
				    	response.setContentType("IMAGE");
					    response.setHeader("Content-Disposition","inline; filename=\"" + filename + "\""); 
					    }
					    
					    else if(FilenameUtils.getExtension(filename).equals("mp3")) {
					    	response.setContentType("audio");
					    	response.setHeader("Content-Disposition","inline; filename=\"" + filename + "\""); 
						    }
					    
					    else if(FilenameUtils.getExtension(filename).equals("mp4")) {
					    	response.setContentType("video/mp4");
					    	response.setHeader("Content-Disposition","inline; filename=\"" + filename + "\"");  
					    }
					    
					    else if(FilenameUtils.getExtension(filename).equals("pdf")) {
					    	response.setContentType("application/pdf");
					    	response.setHeader("Content-Disposition","inline; filename=\"" + filename + "\""); 
						    }
					    
					    else if(FilenameUtils.getExtension(filename).equals("docx") || FilenameUtils.getExtension(filename).equals("doc") || FilenameUtils.getExtension(filename).equals("txt")) {
					    	response.setContentType("application/msword");
					    	response.setHeader("Content-Disposition","inline; filename=\"" + filename + "\""); 
					    	System.out.println(1111111111);
						    }
					    else {
					    	response.setContentType("APPLICATION/OCTET-STREAM");
						    response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");
					    }
				    	
		
				    
				  //----------------------
				    
				     
		
				    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(filepath);
		
				    int i; 
				    while ((i=fileInputStream.read()) != -1) 
				    {
				         response.getWriter().write(i); 
				    } 
				    fileInputStream.close();
				}
				catch(Exception e)
				{
				    System.err.println("Error while downloading file["+filename+"]"+e);
				}
			}	

		} catch (Exception e) {
			request.getRequestDispatcher("/WEB-INF/views/pages/consulterProces.jsp").forward(request, response);
		}	
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONObject obj=new JSONObject();
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		//class from jackson api to convert objects to json strings
		ObjectMapper mapper = new ObjectMapper();
		
		
		if(action.equals("procesById")) {
			int idProces = Integer.parseInt(request.getParameter("procesToBeShown"));
			Proces proces = daoAjouterProces.procesById(idProces) ;
			// transforming proces object to a json string
			String json = mapper.writeValueAsString(proces);
			System.out.println(json);
			out.print(json);
		}
		
		
		else if (action.equals("modifierProces")) {
			
			
			Proces p = new Proces(Integer.parseInt(request.getParameter("procesToBeEdited")),request.getParameter("numeroProcesM"), Date.toDbDate(request.getParameter("dateAcceptationM")), request.getParameter("descriptionM"), request.getParameter("adresseAdvM"), request.getParameter("cinAdvM"), request.getParameter("nomAdvM"), request.getParameter("prenomAdvM"), request.getParameter("avocatAdvM"), request.getParameter("tribunalM"), request.getParameter("villeM"), request.getParameter("numeroSalM"), Date.toDbDate(request.getParameter("dateSeaM")), Date.toDbDate(request.getParameter("dateSuivM")), request.getParameter("jugementM"), Date.toDbDate(request.getParameter("dateJugM")), Date.toDbDate(request.getParameter("dateNotifM")));
			//procesCheck checks if proces's fields are "" or not and then made them null if they are
			int res = daoAjouterProces.procesUpdate(Proces.procesCheck(p));
			// returning the proces new data if it has been updated succefully 
			if(res==1) {
				Proces pu = daoAjouterProces.procesById(Integer.parseInt(request.getParameter("procesToBeEdited")));
				obj.put("nomAdv", pu.getNomAdv() );
				obj.put("prenomAdv", pu.getPrenomAdv());
				obj.put("dateAP", Date.toFDate(pu.getDateAP()));
				obj.put("numP", pu.getNumP() );
			}
			obj.put("res",res);
			out.print(obj);
		}
		
		
		else if (action.equals("modifierFacture")) {
			//Facture f = new Facture(Integer.parseInt(request.getParameter("procesToBeEdited")), Date.toDbDate(request.getParameter("datePayM")), TypeChecker.floatChecker(request.getParameter("lgKmM")), TypeChecker.floatChecker(request.getParameter("prixKmM")), TypeChecker.floatChecker(request.getParameter("dureeJrM")),TypeChecker.floatChecker(request.getParameter("prixJrM")), TypeChecker.floatChecker(request.getParameter("montantBaseM")), Float.parseFloat("0"), TypeChecker.floatChecker(request.getParameter("mtPayeAncienM")), TypeChecker.floatChecker(request.getParameter("mtPayeM")) );
			Facture fid = daoAjouterProces.FactureByIdProces(Integer.parseInt(request.getParameter("procesToBeEdited")));
			//Facture f= new Facture(fid.getIdFacture(), Integer.parseInt(request.getParameter("procesToBeEdited")), TypeChecker.floatChecker(request.getParameter("montantBaseM")), fid.getMtGlobal(), mtPaye) 
			FactureArch fa = new FactureArch(fid.getIdFacture(),  Date.toDbDate(request.getParameter("datePayM")), TypeChecker.floatChecker(request.getParameter("lgKmM")), TypeChecker.floatChecker(request.getParameter("prixKmM")), TypeChecker.floatChecker(request.getParameter("dureeJrM")), TypeChecker.floatChecker(request.getParameter("prixJrM")), TypeChecker.floatChecker(request.getParameter("mtPayeM")));
			
			
			int res =daoAjouterProces.factureUpdate(fid, fa);
			
			obj.put("res", res);
			if(res==1) {
				Facture f = daoAjouterProces.FactureByIdProces(Integer.parseInt(request.getParameter("procesToBeEdited")));
				obj.put("mtGblobal", f.getMtGlobal());
				obj.put("mtPaye",f.getMtpaye());
			}
			out.print(obj);
			
		}
		
		else if(action.equals("supprimerProces")) {
			int res = daoAjouterProces.supprimerProces(Integer.parseInt(request.getParameter("procesToBeDeleted")));
			out.print(res);
		}
		
		else if(action.equals("supprimerPiece")) {
			int res = daoAjouterProces.supprimerPiece(request.getParameter("pieceToBeDeleted"));
			System.out.println(request.getParameter("pieceToBeDeleted"));
			out.print(res);
		}
		
		else if(action.equals("fileUpload")) {
			List<Part> files = request.getParts().stream().filter(part -> "file".equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList());
			ArrayList<Files> filesList = Files.fileUpload(files)	;	
			for(Files ff : filesList) {System.out.println("nom : "+ff.getNomFichier()+"     path : "+ff.getPath());}
			daoAjouterProces.fileUploadDB(filesList, Integer.parseInt(request.getParameter("fileProces")));
			
			request.setAttribute("idProces", Integer.parseInt(request.getParameter("fileProces")));
			request.getRequestDispatcher("/WEB-INF/views/pages/consulterProces.jsp").forward(request, response);
			
		}		
	}


	






}
