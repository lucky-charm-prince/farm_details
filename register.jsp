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

						<%
						String regMsg = (String) session.getAttribute("regMsg");
						String nregMsg = (String) session.getAttribute("nregMsg");
						%>

						<form method="post" action="register">
							<div class="container-fluid back-img text-center text-success">
								<h4 class btn btn-center>Register</h4>
								<hr>
								<%
								if (regMsg != null) {
								%>
								<p><%=regMsg%></p>
								<%
								session.removeAttribute("regMsg");
								}
								if (nregMsg != null) {
								%>
								<p><%=nregMsg%></p>
								<%
								session.removeAttribute("nregMsg");
								}
								%>
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Name :</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="name"
									placeholder="Enter name">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address : </label> <input
									type="email" name="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Contact : </label> <input
									name="contact" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter contact">

							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Password :</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									name="password" placeholder="Password">
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