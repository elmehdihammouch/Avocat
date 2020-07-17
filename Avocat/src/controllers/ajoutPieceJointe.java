package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.daoAjouterProces;
import models.Files;


@WebServlet("/ajoutPieceJointe")
@MultipartConfig
public class ajoutPieceJointe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ajoutPieceJointe() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/pages/ajoutPiecejointe.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(request.getParameter("num")!=null) {
			int num =  Integer.parseInt(request.getParameter("num"));
			request.setAttribute("num", num);
			request.getRequestDispatcher("/WEB-INF/views/pages/ajoutPiecejointe.jsp").forward(request, response);
			}
		
		else if(action.equals("fileUpload")) {
			List<Part> files = request.getParts().stream().filter(part -> "file".equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList());
			ArrayList<Files> filesList = Files.fileUpload(files)	;	
			for(Files ff : filesList) {System.out.println("nom : "+ff.getNomFichier()+"     path : "+ff.getPath());}
			daoAjouterProces.fileUploadDB(filesList, Integer.parseInt(request.getParameter("fileProces")));
			
			request.setAttribute("idProces", Integer.parseInt(request.getParameter("fileProces")));
			request.getRequestDispatcher("/WEB-INF/views/pages/ajoutPiecejointe.jsp").forward(request, response);
			
		}
	}

}
