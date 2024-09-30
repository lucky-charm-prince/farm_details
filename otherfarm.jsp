<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.dao.*"%>

<%@page import="com.dbConnection.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allCss.jsp"%>
<style>
body {
	background-color: #e3e2e1;
}
</style>
</head>
<body>
	<%@include file="component/navbarr.jsp"%>
	<%
	String editMsg = (String) session.getAttribute("editMsg");
	String dMsg = (String) session.getAttribute("dMsg");
	String ndMsg = (String) session.getAttribute("ndMsg");
	%>
	<%
	if (editMsg != null) {
	%>
	<h3 style="background-color: #98cee3"><%=editMsg%></h3>
	<%
	session.removeAttribute("editMsg");
	}
	%>
	<%
	if (dMsg != null) {
	%>
	<h3 style="background-color: #98cee3"><%=dMsg%></h3>
	<%
	session.removeAttribute("dMsg");
	}
	%>
	<%
	if (ndMsg != null) {
	%>
	<h3 style="background-color: #98cee3"><%=ndMsg%></h3>
	<%
	session.removeAttribute("ndMsg");
	}
	%>

	<div class="container">
		<div class="row p-4">

			<%
			UserDao dao = new UserDao(DbConnection.getConnection());

			if (u != null) {

				List<AddPestisides> contact = dao.getAllotherAddpestisides(u.getId());
				
				
 
				for (AddPestisides c : contact) {
			%>

			<div class="col-md-3 ">
				<div class="card crd-ho">
					<div class="card-body">
						<h5>
							CropName:
							<%=c.getCropName()%></h5>
						<p>
							CropAge:
							<%=c.getCropAge()%></p>
						<p>
							PestisidesName:
							<%=c.getPestisidesName()%></p>
						
					</div>
				</div>
			</div>

			<%
			}

			}
			%>




		</div>

	</div>



	<div style="margin-top: 240px">
		<%@include file="component/footer.jsp"%></div>
</body>
</html>