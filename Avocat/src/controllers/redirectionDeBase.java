package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.daoAjouterDossier;
import DAO.daoAjouterProces;
import DAO.daoAjouterProces.notif;
import DAO.daoAjouterDossier.MyResult;

/**
 * Servlet implementation class redirectionDeBase
 */
@WebServlet("/AP")
public class redirectionDeBase extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/pages/factureArchive.jsp").forward(request, response);
		//request.getRequestDispatcher("/WEB-INF/views/pages/ajouterProces.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 if(request.getParameter("notifier").equals("notifier")){
		 	PrintWriter out = response.getWriter();
		 	ObjectMapper mapper = new ObjectMapper();
			ArrayList<notif> res = new ArrayList<>();
			res = daoAjouterProces.listdenotif();
			String json = mapper.writeValueAsString(res);
			out.println(json);	
		}
	}
}
