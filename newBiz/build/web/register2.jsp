<html>
<head>
<title>New User Registration Form</title>
<style type="text/css">
body{
    background-color: #525252;
    background-image:url("css1/g.jpg");
}
.centered-form{
	margin-top: 60px;
              }

.centered-form .panel{
	background: rgba(255, 255, 255, 0.8);
	box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}
.content {
    position: fixed;
    center-right: 120px;
    background: rgba(0, 0, 0, 0.5);
    color: #f1f1f1;
    width: 100%;
    padding: 120px;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
 
<body>
    
    <%@ page import = "javax.servlet.* ,com.javawebtutor.model.User" %>
    <%@ include file = "newheader2.jsp" %>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
<div  class="container">

        <div class="row centered-form" style="text-align:center;">
		

         <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
		 
                 <div class="panel panel-default">
        		        <div class="panel-heading">
			    		<h3 class="panel-title">Please sign up for NexBiz <small>It's free!</small></h3>
			 			</div>
			 			<div class="panel-body">
			    		<form action="newRegisterServlet" method="POST" role="form" name="registration">
                                            <input type="text" name="registerId" class="form-control input-sm" placeholder="<%=user.getUserId()%>" value="<%=user.getUserId()%>"  readonly="" maxlength="10">
			    			<div class="row">
							
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			                           <input type="text" name="firstName" class="form-control input-sm" placeholder="First Name" maxlength="30">
			    					</div>
			    				</div>
								
								<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="text" name="middleName" class="form-control input-sm" placeholder="Middle Name" maxlength="30">
			    					</div>
			    				</div>
								
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="text" name="lastName" class="form-control input-sm" placeholder="Last Name" maxlength="30">
			    					</div>
			    				</div>
								
								<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="number" name="userId" class="form-control input-sm" placeholder="Contact No" maxlength="10">
			    					</div>
			    				</div>
								
			    			</div>
							
							
                                                         
                                                        <div class="form-group">
			    				<input type="text" name="aadhar" class="form-control input-sm" placeholder="Aadhar No" maxlength="40">
			    			        </div>
                                            
                                                        <div class="form-group">
			    				<input type="text" name="address" class="form-control input-sm" placeholder="Address" maxlength="40">
			    			        </div>


			    			<div class="form-group">
			    				<input type="email" name="email" class="form-control input-sm" placeholder="Email Address" maxlength="40">
			    			</div>
							
							<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="text" name="fatherName" class="form-control input-sm" placeholder="Father Name"maxlength="30" >
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="text" name="motherName"  class="form-control input-sm" placeholder="Mother Name" maxlength="30">
			    					</div>
			    				</div>
			    			</div>
							

			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="password" name="password" class="form-control input-sm" placeholder="Password" maxlength="10">
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="password" name="password_confirmation"  class="form-control input-sm" placeholder="Confirm Password" maxlength="10">
			    					</div>
			    				</div>
			    			</div>
			    			
							<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="submit" value="Register" class="btn btn-info btn-block">
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="reset" value="Reset" class="btn btn-info btn-block">
			    					</div>
			    				</div>
			    			        </div>
			    			
							
			    		
			    		</form>
	    		   </div>
		     </div>
    	</div>
			
    	</div>
	</div>
                                     
<%@ include file = "footer.jsp" %>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
<script src="mera/dist/jquery.validate.min.js"></script>
<script src="js/form-validation.js"></script>
</body>
</html>