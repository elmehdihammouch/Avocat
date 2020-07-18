<%@page import="models.Compte"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authentification</title>
	<link rel="icon" href="./resources/media/images/icon.JPG">
<link href="./resources/css/client/bootstrap.min.css" rel="stylesheet">
<link href="./resources/css/client/utilAuth.css" rel="stylesheet">
<link href="./resources/css/client/mainAuth.css" rel="stylesheet">
<link href="./resources/css/client/pfeInterfaceCss.css" rel="stylesheet">
<link href="./resources/font-awesome/css/font-awesome.css" rel="stylesheet">
</head>
<body class="con">	
	<% HttpSession ses = request.getSession();
	 Compte client = null;
	 client = (Compte)session.getAttribute("client"); 
		 if(client!=null)
					 {
			 request.getRequestDispatcher("accueil.jsp").forward(request, response);
					 }
	%> 
	
<jsp:include page="../contents/servicecontent.jsp"></jsp:include>
<jsp:include page="../contents/authentification.jsp"></jsp:include>
<jsp:include page="../contents/contactercontent.jsp"></jsp:include>
</body>
<script type="text/javascript" src="./resources/jquery/jquery.js"></script>
<script type="text/javascript" src="./resources/js/contents/auth.js"></script>
</html>