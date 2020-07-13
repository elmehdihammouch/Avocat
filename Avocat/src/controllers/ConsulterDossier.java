package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.daoAjouterDossier;
import DAO.daoAjouterDossier.MyResult;
import models.Dossier;

/**
 * Servlet implementation class ConsulterDossier
 */
@WebServlet("/ConsulterDossier")
public class ConsulterDossier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConsulterDossier() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/pages/consulterDossier.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if(request.getParameter("operation").equals("modifier")) {	
			System.out.println(request.getParameter("id"));
			Dossier dos = new Dossier(Integer.parseInt(request.getParameter("id")), request.getParameter("type"), request.getParameter("desc").replace("'", "\\'"));
			int stat = Integer.parseInt(request.getParameter("etat"));
			MyResult res = new MyResult(dos, stat);
			daoAjouterDossier.modif(res);
			out.println(1);
			
			
			
		} 
		else if(request.getParameter("operation").equals("delete")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			daoAjouterDossier.delete(id);
			out.println(1);
		}
	}

}
