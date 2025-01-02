<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index page</title>
<!-- including external css -->
<link rel="stylesheet" href= "<%= application.getContextPath() %>/css/style.css" />
</head>
<body>
	<!-- Include the menu -->
    <jsp:include page="menu.jsp" />
	<div class="container">
		<h1>Welcome to servlet</h1>
		<p>This is very important concepts about servlet</p>
		<form action="<%=application.getContextPath()%>/third" method="post">
		
			<input name="message" type="text" placeholder="enter text here" />
			<button type="submit">Submit</button>
		</form>
	</div>
<script src="<%= application.getContextPath() %>/js/script.js"></script>	
</body>
</html>