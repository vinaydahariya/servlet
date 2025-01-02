<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>about page</title>
<!-- including external css -->
<link rel="stylesheet" href= "<%= application.getContextPath() %>/css/style.css" />
</head>
<body>
	<!-- Include the menu -->
    <jsp:include page="menu.jsp" />
	<div class="container">
		<h1>About our page</h1>
		<p>This page provide our information for you</p>
	</div>
<script src="<%= application.getContextPath() %>/js/script.js"></script>	
</body>
</html>