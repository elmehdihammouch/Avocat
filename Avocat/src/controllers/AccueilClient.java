package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.daoAjouterProces;
import models.Proces;

@WebServlet("/AccueilClient")
public class AccueilClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AccueilClient() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/pages/accueil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		//class from jackson api to convert objects to json strings
		ObjectMapper mapper = new ObjectMapper();
		if(request.getParameter("num")!=null) {
		int num =  Integer.parseInt(request.getParameter("num"));
		request.setAttribute("num", num);
		request.getRequestDispatcher("/WEB-INF/views/pages/accueil.jsp").forward(request, response);
		}else  if(action.equals("procesById")) {
			int idProces = Integer.parseInt(request.getParameter("procesToBeShown"));
			Proces proces = daoAjouterProces.procesById(idProces) ;
			// transforming proces object to a json string
			String json = mapper.writeValueAsString(proces);
			out.print(json);
		}
		
		
		
	}

}
