package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import models.Client;
import models.Consultation;


@WebServlet("/AjouterConsultation")
public class AjouterConsultation extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    public AjouterConsultation() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/pages/ajoutConsultation.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if(request.getParameter("operation").equals("check")) {
			if(DAO.daoAjouterConsultation.chercherClient(request.getParameter("cinClientAD"))==1) {
				out.println("1");
			}
		}else if(request.getParameter("operation").equals("add")) {
			String d = request.getParameter("dateNais");
			Date datenais = Date.valueOf(d);
			Client client = new Client(request.getParameter("nom"),request.getParameter("prenom"),datenais,request.getParameter("lieuNais"),request.getParameter("nationalite"),request.getParameter("adresse"),request.getParameter("cin"),request.getParameter("municipale"),request.getParameter("telephone"),request.getParameter("email"));
			DAO.daoAjouterConsultation.ajoutclient(client);
			out.println("1") ;
		}else if(request.getParameter("operation").equals("addc")){
			Consultation cons = new Consultation(request.getParameter("type"),request.getParameter("desc"),Float.parseFloat(request.getParameter("frais")));
			String cin=request.getParameter("cinClientAD") ;
			DAO.daoAjouterConsultation.ajoutConsultation(cons, cin);
			out.println("1") ;
			
		}
		
	}

}
