<%@page import="java.util.List"%>
<%@page import="com.javawebtutor.service.LoginService"%>
<%@page import="java.util.Date"%>

<%@page import="com.javawebtutor.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Welcome To Dashboard</title>

    <!-- Bootstrap core CSS -->
    <link href="css2/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
  </head>

  <body>
   <%@ include file = "newheader3.jsp" %>
  <div class="container-fluid">
      <div class="row">
        <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
          <h5> Explore Here</h5>
          <ul class="nav nav-pills flex-column">
            <li class="nav-item">
              <a class="nav-link active" href="home.jsp">Go to Home<span class="sr-only">(current)</span></a>
            </li>
           
            <li class="nav-item">
              <a class="nav-link" href="jsptree.jsp">Tree View</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="register2.jsp">Add Client</a>
            </li>
          </ul>

          

          
        </nav>
          <!--/span-->
        <div class="col-12 col-md-9">
            
          <br/>
          <br/>
          <h1>Dashboard</h1>
          <h3>Welcome <%= user.getFirstName() + " " + user.getLastName()%></h3>
          <section class="row text-center placeholders">
            <div class="col-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIABAAJ12AAAACwAAAAAAQABAAACAkQBADs=" width="150" height="150" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail">
              <h4>Your Earnings</h4>
              <div class="text-muted">Rs <%=user.getEarnings() %></div>
            </div>
            <div class="col-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIABAADcgwAAACwAAAAAAQABAAACAkQBADs=" width="150" height="150" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail">
              <h4>Date</h4>
              <span class="text-muted"><%=new Date()%></span>
            </div>
            <div class="col-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIABAAJ12AAAACwAAAAAAQABAAACAkQBADs=" width="150" height="150" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail">
              <h4>Your Address</h4>
              <span class="text-muted"><%= user.getaddress() %></span>
            </div>
            <div class="col-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIABAADcgwAAACwAAAAAAQABAAACAkQBADs=" width="150" height="150" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail">
              <h4>Contact Your Sponse</h4>
              <span class="text-muted"><%=user.getRegisterId() %></span>
            </div>
          </section>

          <h2>Clients</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>User ID</th>
	          <th>First Name</th>
	          <th>Middle Name</th>
		   <th>Last Name</th>
                   <th>Father Name</th>
                   <th>Mother Name</th>
		   <th>email</th>
                </tr>
              </thead>
              <tbody>
                  <%
					 LoginService loginService = new LoginService();
					 List<User> list = loginService.getListOfAllUsers();
					 for (User u : list) {
				 %>
                <tr>
                  <td><%=u.getUserId()%></td>
					 <td><%=u.getFirstName()%></td>
					 <td><%=u.getMiddleName()%></td>
					 <td><%=u.getLastName()%></td>
                                         <td><%=u.getFatherName()%></td>
                                         <td><%=u.getMotherName()%></td>
					 <td><%=u.getEmail()%></td>
                </tr>
                 <%}%>
              </tbody>
            </table>
          </div>
        </div>
   </div>
  </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="vendor/jquery/jquery.min.js"><\/script>');</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <%@ include file = "footer.jsp" %>
  </body>
</html>
