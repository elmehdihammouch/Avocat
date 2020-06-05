package controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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

import DAO.daoAjouterDossier;
import DAO.daoAjouterProces;
import models.Client;
import models.Dossier;
import models.Facture;
import models.Files;
import models.Proces;

/**
 * Servlet implementation class AjouterDossier
 */
@WebServlet("/AD")
@MultipartConfig
public class AjouterDossier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjouterDossier() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/pages/ajouterDossier.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	String cin;
	if(request.getParameter("operation").equals("check")) {
		
		cin = request.getParameter("cinClientAD");
		if(DAO.daoAjouterDossier.chercherDossier(cin)==1) {
			out.println("1");
		}
	}else if(request.getParameter("operation").equals("add")) {
		String d = request.getParameter("dateNais");
		Date datenais = Date.valueOf(d);
		Client client = new Client(request.getParameter("nom"),request.getParameter("prenom"),datenais,request.getParameter("lieuNais"),request.getParameter("nationalite"),request.getParameter("adresse"),request.getParameter("cin"),request.getParameter("municipale"),request.getParameter("telephone"),request.getParameter("email"));
		DAO.daoAjouterDossier.ajoutclient(client);
		DAO.daoAjouterDossier.ajoutcompte(client);
		out.println("1") ;
	}else if(request.getParameter("operation").equals("addDF")){
		String statutR = request.getParameter("statut");
		//traitement du statut du dossier
		int statut=0;	
		if(statutR.equals("premiere Instance")) {statut=1;}
		else if(statutR.equals("deuxieme Instance")) {statut=2;}
		else if(statutR.equals("troisieme Instance")) {statut=3;}
		cin = request.getParameter("cinClientAD");
		Dossier dos = new Dossier(statut, request.getParameter("typeProces"), request.getParameter("Description"));	
		daoAjouterDossier.ajoutdossier(dos, cin);
		if(daoAjouterDossier.chercherEtatCompte(cin)==0) {
			Client client = new Client();
			client.setCin(cin);
			daoAjouterDossier.ajoutcompte(client);}
			int idDos = daoAjouterDossier.idDos();
			String nomAdv= request.getParameter("nomAdv");
			String prenomAdv = request.getParameter("prenomAdv");
			String cinAdv = request.getParameter("cinAdv");
			String adresseAdv = request.getParameter("adresseAdv");
			String avocatAdv = request.getParameter("avocatAdv");
			String description = request.getParameter("description");
			
			//fichiers du proces
			List<Part> files = request.getParts().stream().filter(part -> "file".equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList());
			//donnees de la facture
			int FMB =Integer.parseInt(request.getParameter("FMB"));
			int prixKm;
			try {
				prixKm =Integer.parseInt(request.getParameter("prixKm"));
		    } catch (final NumberFormatException e) {
		         prixKm = -1;
		    }
			int mtGlobal =Integer.parseInt(request.getParameter("mtGlobal"));
			int mtPaye =Integer.parseInt(request.getParameter("mtPaye"));
			//dates
			tools.Date datePay = tools.Date.toDbDate(request.getParameter("datePay"));
			tools.Date dateNotif = tools.Date.toDbDate(request.getParameter("dateNotif"));
			
			Facture facture = new Facture( datePay, prixKm, FMB, mtGlobal, mtPaye);		
					
			ArrayList<Files> filesList = Files.fileUpload(files)	;	
			Proces p = new Proces(idDos, description, adresseAdv, cinAdv, nomAdv, prenomAdv, avocatAdv, filesList, facture,dateNotif,statut);
			daoAjouterProces.ajouterProces(p);

		}
		
	}
	
	}

