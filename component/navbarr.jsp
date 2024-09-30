
<%@page import="com.entity.*" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
<%User u= (User)session.getAttribute("user");


%>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <%if(u==null){ %>
      <li class="nav-item active">
        <a class="nav-link" href="">Our-Fram</a>
      </li>
       <li class="nav-item active">
        <a class="nav-link" href="">Other-farm</a>
      </li>
     
      <li class="nav-item active">
        <a class="nav-link " href="">Add-Pestisides</a>
      </li>
    </ul>
    
    <form class="form-inline my-2 my-lg-0 ">
    
      <a href="login.jsp" class="btn btn-success " type="submit">Login</a>
      <a href="register.jsp" class="btn btn-danger ml-2" type="submit">Register</a>
      
    </form>
    <%} else {%>
     <li class="nav-item active">
        <a class="nav-link" href="ourfarm.jsp">Our-Fram</a>
      </li>
       <li class="nav-item active">
        <a class="nav-link" href="otherfarm.jsp">Other-farm</a>
      </li>
     
      <li class="nav-item active">
        <a class="nav-link " href="addpestiside.jsp">Add-Pestisides</a>
      </li>
    </ul>
    
    <form class="btn btn text-center" action="search" method="post" >
				
				  <input type="hidden" name="userId" value="<%=u.getId() %>" >
				   <input type="text" name="searchName" placeholder="search">
				   <button type="submit" class="btn btn-success ">Search</button>
				</form>
    
    <form class="form-inline my-2 my-lg-0 "  >
    
      <a href="" class="btn btn-success " type="submit"><%=u.getName() %></a>
     		<a data-toggle="modal"
				data-target="#exampleModalCenter" class="btn btn-danger ml-2"><i
					class="fa-solid fa-users"></i> logout</a>
			</form>
			<!-- Button trigger modal -->
			
			<!-- Modal -->
			<div class="modal fade" id="exampleModalCenter" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalCenterTitle"
				aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle">Logout</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body text-center" ><h6>Press yes if you want to logout</h6>
						<button type="button" class="btn btn-secondary"
								data-dismiss="modal">No</button>
							<a href="logout" type="button" class="btn btn-primary">LogOut</a>
							</div>
						<div class="modal-footer">
							
						</div>
					</div>
				</div>
			</div>
      <%} %>
      
    </form>
  </div>
</nav>