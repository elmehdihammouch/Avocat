package controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.daoAjouterProces;
import models.Proces;

/**
 * Servlet implementation class ConsulterProces
 */
@WebServlet("/ConsulterProces")
public class ConsulterProces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
			    response.setContentType("APPLICATION/OCTET-STREAM");
			    response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\""); 
	
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
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	}

}
