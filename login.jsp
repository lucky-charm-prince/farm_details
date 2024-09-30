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

<% 
String notLogin=(String)session.getAttribute("notLogin");
String logoutMsg=(String)session.getAttribute("logoutMsg"); %>
	<div class="container-fluid	abc">
		<div class="row p-2 ">
			<div class="col-md-4 offset-md-4  mt-4 ">
				<div class="card">
					<div class="card-body">

						

						<form method="post" action="login">
						
							<div class="container-fluid back-img text-center text-success">
						
								<h4 class btn btn-center>Login</h4>
								<%if(logoutMsg!=null)
							{ %>
							<p class ="text-center text-success"><%=logoutMsg%></p>
							<%
							   session.removeAttribute("logoutMsg");
							}
							%>
								<%if(notLogin!=null)
							{ %>
							<p class ="text-center text-danger"><%=notLogin%></p>
							<%
							   session.removeAttribute("notLogin");
							}
							%>	
								<hr>
							
							</div>

						
							<div class="form-group">
								<label for="exampleInputEmail1">Email address : </label> <input
									type="email" name="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email">

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
	<div style="margin-top: 240px">
		<%@include file="component/footer.jsp"%></div>
</body>
</html>