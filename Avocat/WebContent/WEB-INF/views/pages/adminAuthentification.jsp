<%@page import="models.Administrateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
   <link href="./resources/css/contents/mainAuth.css" rel="stylesheet">
  <link href="./resources/css/contents/utilAuth.css" rel="stylesheet">
 <link href="./resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
 <link href="./resources/font-awesome/css/font-awesome.css" rel="stylesheet">


</head>
<body>
<%	 HttpSession ses = request.getSession();
	 Administrateur admin = null;
	 admin = (Administrateur)session.getAttribute("admin"); 
	 if(admin!=null){
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}	 %>
	<jsp:include page="../contents/adminauth.jsp"></jsp:include>
</body>
	<script type="text/javascript" src="./resources/jquery/jquery.js"></script>
	
	<script type="text/javascript" src="./resources/js/contents/auth.js"></script>
</html>
