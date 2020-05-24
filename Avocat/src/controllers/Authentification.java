package controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.daoAuthentification;
import models.Administrateur;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action=request.getParameter("action");
		//traitement d'authentification du avocat
		if(action.equals("connecter")) {
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			Administrateur admin;
			HttpSession ses = request.getSession(true);
			admin=daoAuthentification.adminAuthentification(email, password);
			
			if(admin!=null) {
				ses.setAttribute("admin", admin);
				request.getRequestDispatcher("/WEB-INF/views/pages/ajouterProces.jsp").forward(request, response);
			}
			else {
				request.setAttribute("ERROR", "Login ou Mot de passe incorrecte");
				request.getRequestDispatcher("/WEB-INF/views/pages/adminAuthentification.jsp").forward(request, response);
			}
				
			
			
		}
	}

}
