<%@page import="models.Compte"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link href="./resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
 <link href="./resources/font-awesome/css/font-awesome.css" rel="stylesheet">
 	 <!--------- table css ------->
	 <link href="./resources/font-awesome/css/material-design-iconic-font.min.css" rel="stylesheet">
	 <link href="./resources/css/contents/tableCss/select2.min.css" rel="stylesheet">
	 <link href="./resources/css/contents/tableCss/tableTheme.css" rel="stylesheet">
	 <!-- --------------------- -->
	 <link href="./resources/css/headers/style.css" rel="stylesheet">
	 <link href="./resources/css/headers/style-responsive.css" rel="stylesheet">
	 <script src="https://kit.fontawesome.com/dc70a27419.js" crossorigin="anonymous"></script>	


</head>
<body>
<% HttpSession ses = request.getSession();
	 Compte client = null;
	 client = (Compte)session.getAttribute("client"); 
		 if(client==null)
					 {
			 request.getRequestDispatcher("ClientAuthentification.jsp").forward(request, response);
					 }
	%> 
	
	<jsp:include page="../headers/headerAfterAuthClient.jsp"></jsp:include>
	<%Integer i =(Integer) request.getAttribute("num");
	  if(i==null){
	%>
	<jsp:include page="../components/Proces.jsp"></jsp:include>
	<%}else{%>
	<jsp:include page="../components/ajoutpiecejointe.jsp"></jsp:include>

	<% } %>
</body>
	<script type="text/javascript" src="./resources/jquery/jquery.js"></script>
 	<script type="text/javascript" src="./resources/js/headers/jquery.dcjqaccordion.2.7.js"></script>
  	<script type="text/javascript" src="./resources/js/headers/jquery.scrollTo.min.js"></script>
    <script type="text/javascript" src="./resources/js/headers/jquery.nicescroll.js"></script>
    <script type="text/javascript" src="./resources/js/headers/common-scripts.js"></script>
    <script type="text/javascript" src="./resources/js/contents/ajoutpiece.js"></script>
</html>