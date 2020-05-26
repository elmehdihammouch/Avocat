package controllers;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class AjouterDossier
 */
@WebServlet("/abc")
public class AjouterDossier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjouterDossier() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	if(request.getParameter("operation").equals("check")) {
		if(DAO.daoAjouterDossier.chercherDossier(request.getParameter("cinClientAD"))==1) {
			out.println("1");
		}
	}
	}

}
