package controllers;

import java.io.IOException; 
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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


import DAO.daoAjouterProces;
import models.Dossier;
import models.Facture;
import models.Files;
import models.Proces;
import tools.Date;

/**
 * Servlet implementation class AjouterProces
 */
@WebServlet("/AjouterProces")
@MultipartConfig
public class AjouterProces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		
		
		
		
		
		
		//return du dossier choisit par l'utilisateur
		if(action.equals("choixDossier")) {
			
			
			int exist=daoAjouterProces.chercherDossier(request.getParameter("cinClient"));
			if(exist==0) {
			out.print(exist);
			
			}
		
			else {
				
			ArrayList<Dossier> dossiers= new ArrayList<Dossier>();
			dossiers= daoAjouterProces.dossierClient(request.getParameter("cinClient"));
			
			request.setAttribute("dossiers", dossiers);
			//request.getRequestDispatcher("/WEB-INF/views/pages/ajouterProces2.jsp").forward(request, response);
			request.getRequestDispatcher("/WEB-INF/views/pages/ajouterProces.jsp").forward(request, response);
			}
		}	
		
		//traitement d'ajout du proces
		else if(action.equals("donneesProces")) {
			int idDos = Integer.parseInt(request.getParameter("idDossierClicked"));
			String nomAdv= request.getParameter("nomAdv");
			String prenomAdv = request.getParameter("prenomAdv");
			String cinAdv = request.getParameter("cinAdv");
			String adresseAdv = request.getParameter("adresseAdv");
			String avocatAdv = request.getParameter("avocatAdv");
			String description = request.getParameter("description");
			String statutR = request.getParameter("statut");
			//traitement du statut du dossier
			int statut=0;	
			if(statutR.equals("premiere Instance")) {statut=1;}
			else if(statutR.equals("deuxieme Instance")) {statut=2;}
			else if(statutR.equals("troisieme Instance")) {statut=3;}
			//fichiers du proces
			List<Part> files = request.getParts().stream().filter(part -> "file".equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList());
			//donnees de la facture
			int FMB =Integer.parseInt(request.getParameter("FMB"));
			int prixKm =Integer.parseInt(request.getParameter("prixKm"));
			int mtGlobal =Integer.parseInt(request.getParameter("mtGlobal"));
			int mtPaye =Integer.parseInt(request.getParameter("mtPaye"));
			//dates
			Date datePay = Date.toDbDate(request.getParameter("datePay"));
			Date dateNotif = Date.toDbDate(request.getParameter("dateNotif"));
			
			Facture facture = new Facture( datePay, prixKm, FMB, mtGlobal, mtPaye);		
					
			ArrayList<Files> filesList = Files.fileUpload(files)	;	
			Proces p = new Proces(idDos, description, adresseAdv, cinAdv, nomAdv, prenomAdv, avocatAdv, filesList, facture,dateNotif,statut);
			daoAjouterProces.ajouterProces(p);
			
		
			
			
		}
	}

}
