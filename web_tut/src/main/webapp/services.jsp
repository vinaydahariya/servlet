<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>services page</title>
<!-- including external css -->
<link rel="stylesheet" href= "<%= application.getContextPath() %>/css/style.css" />
</head>
<body>
	<!-- Include the menu -->
    <jsp:include page="menu.jsp" />
	<div class="container">
		<h1>services offered by substring technologies</h1>
		<p>this page provide to you services</p>
	</div>
<script src="<%= application.getContextPath() %>/js/script.js"></script>	
</body>
</html>