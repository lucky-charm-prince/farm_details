<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

						<%String addMsg=(String)session.getAttribute("addMsg");
						String naddMsg=(String)session.getAttribute("naddMsg");%>
						

						<form method="post" action="addpestisides">
						 <input type="hidden" value="<%=u.getId()%>" name="userId">
							<div class="container-fluid back-img text-center text-success">
								<h4 class btn btn-center>Add Pestisides</h4>
								<%if(addMsg!=null) 
								{%>
								<p class ="text-center text-success"><%=addMsg%></p>
								<%
								   session.removeAttribute("addMsg");
								}
								if(naddMsg!=null)
								{
								%>
								<p class ="text-center text-success"><%=naddMsg%></p>
								<%
								   session.removeAttribute("naddMsg");
								}
								 %>
																<hr>
								
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Crop Name :</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="cropName"
									placeholder="Enter crop name">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Crop Age : </label> <input
									type="text" name="cropAge" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter total days">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Pestisides Name : </label> <input
									name="pestisidesName" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter pestisides name">

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