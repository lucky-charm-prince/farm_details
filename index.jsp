<%@page import="com.dbConnection.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allCss.jsp" %>
<style>
.back-img {
	background-image:
		url('http://localhost:8080/Farm_details/image/farm2.avif');
	width: 100%;
	height: 80vh;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>

<%@include file="component/navbar.jsp" %>
	<div class="container-fluid back-img text-center text-danger">
		<h1>WelCome To Farmer App</h1>
	</div>
	<%@include file="component/footer.jsp" %>
</body>
</html>