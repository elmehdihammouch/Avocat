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
import models.Client;
import models.Compte;

@WebServlet("/AuthentificationClient")
public class AuthentificationClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AuthentificationClient() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/pages/ClientAuthentification.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//traitement d'authentification du avocat
			String email=request.getParameter("email");
			String password=request.getParameter("pass");
			Compte client;
			HttpSession ses = request.getSession(true);
			client=daoAuthentification.clientAuthentification(email, password);
			
			if(client!=null) {
				ses.setAttribute("client", client);
				request.getRequestDispatcher("/WEB-INF/views/pages/accueil.jsp").forward(request, response);
			}else{
				request.setAttribute("ERROR", "Login ou Mot de passe incorrecte");
				request.getRequestDispatcher("/WEB-INF/views/pages/ClientAuthentification.jsp").forward(request, response);
			}
				
			
			
		
	}
}

