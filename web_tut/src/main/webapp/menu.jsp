<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Bar</title>
<!-- Internal CSS for Menu Styling -->
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }

    .menu-bar {
        background-color: #333;
        overflow: hidden;
    }

    .menu-bar a {
        float: left;
        display: block;
        color: white;
        text-align: center;
        padding: 14px 20px;
        text-decoration: none;
    }

    .menu-bar a:hover {
        background-color: #575757;
        color: white;
    }

    .menu-bar .dropdown {
        float: left;
        overflow: hidden;
    }

    .menu-bar .dropdown .dropbtn {
        font-size: 16px; 
        border: none;
        outline: none;
        color: white;
        padding: 14px 20px;
        background-color: inherit;
        font-family: inherit;
        margin: 0;
    }

    .menu-bar .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
    }

    .menu-bar .dropdown-content a {
        float: none;
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
        text-align: left;
    }

    .menu-bar .dropdown-content a:hover {
        background-color: #ddd;
        color: black;
    }

    .menu-bar .dropdown:hover .dropdown-content {
        display: block;
    }

    .menu-bar .dropdown:hover .dropbtn {
        background-color: #575757;
    }
</style>
</head>
<body>
    <div class="menu-bar">
        <a href="index.jsp">Home</a>
        <a href="about.jsp">About</a>
        <a href="services.jsp">Services</a>
    </div>
</body>
</html>
