<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="./resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	 <link href="./resources/font-awesome/css/font-awesome.css" rel="stylesheet">
	  <link href="./resources/css/headers/style.css" rel="stylesheet">
	 <link href="./resources/css/headers/style-responsive.css" rel="stylesheet">
	 <link href="./resources/css/contents/ajouterClient.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="../headers/headerAfterAuth.jsp"></jsp:include>
	<jsp:include page="../contents/ajoutConsultationContent.jsp"></jsp:include>
	<div id="add" style="display:none">
		<jsp:include page="../contents/ajouterClientContent.jsp"></jsp:include>
	</div>


</body>
	<script type="text/javascript" src="./resources/jquery/jquery.js"></script>
  	<script type="text/javascript" src="./resources/js/headers/jquery.dcjqaccordion.2.7.js"></script>
  	<script type="text/javascript" src="./resources/js/headers/jquery.scrollTo.min.js"></script>
    <script type="text/javascript" src="./resources/js/headers/jquery.nicescroll.js"></script>
    <script type="text/javascript" src="./resources/js/headers/common-scripts.js"></script>
    <script type="text/javascript" src="./resources/js/contents/consultation.js"></script>
    
</html>