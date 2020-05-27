package controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import models.Client;

/**
 * Servlet implementation class AjouterDossier
 */
@WebServlet("/AD")
public class AjouterDossier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjouterDossier() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("nom")+request.getParameter("prenom")+request.getParameter("lieuNais")+request.getParameter("nationalite")+request.getParameter("adresse")+request.getParameter("cin")+request.getParameter("municipale")+request.getParameter("telephone")+request.getParameter("email")+request.getParameter("dateNais"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	if(request.getParameter("operation").equals("check")) {
		if(DAO.daoAjouterDossier.chercherDossier(request.getParameter("cinClientAD"))==1) {
			out.println("1");
		}
	}else if(request.getParameter("operation").equals("add")) {
		String d = request.getParameter("dateNais");
		Date datenais = Date.valueOf(d);
		Client client = new Client(request.getParameter("nom"),request.getParameter("prenom"),datenais,request.getParameter("lieuNais"),request.getParameter("nationalite"),request.getParameter("adresse"),request.getParameter("cin"),request.getParameter("municipale"),request.getParameter("telephone"),request.getParameter("email"));
		DAO.daoAjouterDossier.ajoutclient(client);
		DAO.daoAjouterDossier.ajoutcompte(client);
	}
	
	}

}