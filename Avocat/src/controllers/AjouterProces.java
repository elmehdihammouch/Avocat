package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.daoAjouterProces;

/**
 * Servlet implementation class AjouterProces
 */
@WebServlet("/AjouterProces")
public class AjouterProces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		
		
		
		
		
		if(action.equals("choixDossier")) {
			int exist=daoAjouterProces.chercherDossier(Integer.parseInt(request.getParameter("idDossier")));
			out.print(exist);
			
		}
	}

}
