package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Client;

/**
 * Servlet implementation class AjouterClient
 */
@WebServlet("/Add")
public class AjouterClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjouterClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
			System.out.println(request.getParameter("nom")+request.getParameter("prenom")+request.getParameter("lieuNais")+request.getParameter("nationalite")+request.getParameter("adresse")+request.getParameter("cin")+request.getParameter("municipale")+request.getParameter("telephone")+request.getParameter("email")+request.getParameter("dateNais"));

		
	}

}
