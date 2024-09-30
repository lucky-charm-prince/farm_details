<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.dao.*"%>
	<%@page import="com.dbConnection.*" %>
	
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
	<%@include file="component/navbar.jsp"%>


	<div class="container-fluid	abc">
		<div class="row p-2 ">
			<div class="col-md-6 offset-md-3  mt-4 ">
				<div class="card">
					<div class="card-body">


<%int id=Integer.parseInt(request.getParameter("cid" ));
  
  UserDao  dao = new UserDao(DbConnection.getConnection());
  AddPestisides ad=dao.getAllourfarm(id);
  String neditMsg=(String)session.getAttribute("neditMsg");
  
%>

						<form method="post" action="edit">
						
							<input type="hidden" value="<%=id%>" name="id">
							<div class="container-fluid back-img text-center text-success">
								<h4 class btn btn-center>Edit Pestisides</h4>
								<%
								 if(neditMsg!=null)
								 {
								%>
								<p><%=neditMsg%></p>
								<% 
								session.removeAttribute("neditMsg");
								}
								%>
								
                             								<hr>

							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Crop Name :</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="cropName" value="<%=ad.getCropName() %>">


							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Crop Age : </label> <input
									type="text" name="cropAge" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									value="<%=ad.getCropAge() %>">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Pestisides Name : </label> <input
									name="pestisidesName" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									value="<%=ad.getPestisidesName()%>" >

							</div>


							<div class="text-center mt-2">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 70px">
		<%@include file="component/footer.jsp"%></div>
</body>
</html>