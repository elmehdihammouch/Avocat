<%@page import="models.Administrateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link href="./resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
 <link href="./resources/font-awesome/css/font-awesome.css" rel="stylesheet">
 <link href="./resources/css/headers/style-responsive.css" rel="stylesheet">
 <link href="./resources/css/headers/style.css" rel="stylesheet">
 <link href="./resources/css/contents/ajouterProces.css" rel="stylesheet">
<title>Avocat</title>
</head>
<body>
<%HttpSession ses = request.getSession();
 Administrateur admin = null;
 admin = (Administrateur)session.getAttribute("admin"); 
 if(admin==null)
			 {
	 request.getRequestDispatcher("adminAuthentification.jsp").forward(request, response);
			 }
			
%>
<jsp:include page="../headers/headerAfterAuth.jsp"></jsp:include>
<jsp:include page="../contents/ajouterProcesContent.jsp"></jsp:include>


 




</body>
<script type="text/javascript" src="./resources/jquery/jquery.js"></script>
<script type="text/javascript" src="./resources/js/headers/jquery.dcjqaccordion.2.7.js"></script>
<script type="text/javascript" src="./resources/js/headers/jquery.scrollTo.min.js"></script>
<script type="text/javascript" src="./resources/js/headers/jquery.nicescroll.js"></script>
<script type="text/javascript" src="./resources/js/headers/common-scripts.js"></script>
<script type="text/javascript" src="./resources/js/contents/ajouterProces.js"></script>
 
</html>