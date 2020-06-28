package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.daoAjouterDossier;
import DAO.daoClient;
import models.Client;
import models.Compte;

/**
 * Servlet implementation class ConsulterClient
 */
@WebServlet("/ConsulterClient")
public class ConsulterClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConsulterClient() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if(request.getParameter("operation").equals("modifier")) {			
			Compte compte = new Compte(Integer.parseInt(request.getParameter("id")), request.getParameter("emailCl"), request.getParameter("password"), Integer.parseInt(request.getParameter("statut")));
			Client client = new Client(Integer.parseInt(request.getParameter("id")),request.getParameter("nom"), request.getParameter("prenom"),
			Date.valueOf(request.getParameter("datenais")),request.getParameter("lieunais"), request.getParameter("adresse"), request.getParameter("municipale"), 
			request.getParameter("telephone"), request.getParameter("email"), compte);
			daoClient.modif(client);
			out.println(1);
			
			
			
		}else if(request.getParameter("operation").equals("mod")) {
			
			Client client = new Client(Integer.parseInt(request.getParameter("id")),request.getParameter("nom"), request.getParameter("prenom"),
			Date.valueOf(request.getParameter("datenais")),request.getParameter("lieunais"), request.getParameter("adresse"), request.getParameter("municipale"), 
			request.getParameter("telephone"), request.getParameter("email"));
			daoClient.modifier(client);
			
			out.println(1);
			
			
			
		} 
		else if(request.getParameter("operation").equals("delete")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			daoClient.delete(id);
			out.println(1);
		}
		
		
	
	}

}
