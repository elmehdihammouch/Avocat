<%@page import="models.Administrateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	 	<link rel="icon" href="./resources/media/images/icon.JPG">
	 <link href="./resources/css/contents/ajouterDossier.css" rel="stylesheet">
	 <link href="./resources/css/contents/ajouterClient.css" rel="stylesheet">
	 <link href="./resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	 <link href="./resources/font-awesome/css/font-awesome.css" rel="stylesheet">
	  <link href="./resources/css/headers/style.css" rel="stylesheet">
	 <link href="./resources/css/headers/style-responsive.css" rel="stylesheet">
	 <script src="https://kit.fontawesome.com/dc70a27419.js" crossorigin="anonymous"></script>
	 
	<title>Ajout d'un dossier</title>
</head>
<body style="background: #ffffff;">
<% HttpSession ses = request.getSession();
	 Administrateur admin = null;
	 admin = (Administrateur)session.getAttribute("admin"); 
		 if(admin==null)
					 {
			 request.getRequestDispatcher("adminAuthentification.jsp").forward(request, response);
					 }
	%> 
	<jsp:include page="../headers/headerAfterAuth.jsp"></jsp:include>
	<jsp:include page="../contents/ajouterDossierContent.jsp"></jsp:include>
<div id="add" style="display:none">
	<jsp:include page="../contents/ajouterClientContent.jsp"></jsp:include>
</div>
 
      
</body>
 	<script type="text/javascript" src="./resources/jquery/jquery.js"></script>
  	<script type="text/javascript" src="./resources/js/headers/jquery.dcjqaccordion.2.7.js"></script>
  	<script type="text/javascript" src="./resources/js/headers/jquery.scrollTo.min.js"></script>
    <script type="text/javascript" src="./resources/js/headers/jquery.nicescroll.js"></script>
    <script type="text/javascript" src="./resources/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./resources/js/headers/common-scripts.js"></script>
    <script type="text/javascript" src="./resources/js/contents/ajouterDossier.js"></script>
	<script type="text/javascript" src="./resources/js/headers/test.js"></script>    

</html>
