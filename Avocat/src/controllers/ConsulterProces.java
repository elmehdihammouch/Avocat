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

/**
 * Servlet implementation class ConsulterProces
 */
@WebServlet("/ConsulterProces")
public class ConsulterProces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		//class from jackson api to convert objects to json strings
		ObjectMapper mapper = new ObjectMapper();
		
		
		if(action.equals("procesById")) {
			int idProces = Integer.parseInt(request.getParameter("procesToBeShown"));
			Proces proces = daoAjouterProces.procesById(idProces) ;
			// transforming proces object to a json string
			String json = mapper.writeValueAsString(proces);
			System.out.println(json);
			out.print(json);
		}
	}

}
