<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login Page</title>

<link href="css1/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@ include file = "newheader.jsp" %>
<div class="loginbox">
<img src="p.jpg" class="pic">
<form method="post" action="LoginServlet">
<H2>Login Page</H2>
<p style="color: greenyellow">Please provide your credential to use this website</p>
<br />
<br />
<p>Mobile No:</p>
<input type="number" name="userId" class="form-login" title="Mobile NO" placeholder="Enter Mobile No." />
<p>Password:</p>
<input name="password" type="password" class="form-login" title="Password" placeholder="Enter Password." />
<span class="login-box-options">
    New User?  <b><a href="register.jsp" style="margin-left:30px;"><u>Register Here</u></a></b>
</span>
<br />
<br />
<input type="submit" value="Login" />

</form>
</div>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>


<%@ include file = "footer.jsp" %>
 </body>
</html>
