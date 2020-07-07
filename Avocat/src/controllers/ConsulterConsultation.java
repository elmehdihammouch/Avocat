package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.daoAjouterConsultation;
import DAO.daoClient;
import models.Client;
import models.Compte;

/**
 * Servlet implementation class ConsulterConsultation
 */
@WebServlet("/CC")
public class ConsulterConsultation extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    public ConsulterConsultation() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/pages/consultation.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		if(request.getParameter("operation").equals("delete")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			daoAjouterConsultation.delete(id);
			out.println(1);
		}

	}

}
