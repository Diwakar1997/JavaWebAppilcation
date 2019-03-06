<html>
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1">
	 <link rel="stylesheet" type="text/css" href="css1/style.css">
	 <title>logout Page</title>
         <style>
             #rcorners3 {
                   border-radius: 15px 50px;
                   background: #808080;
                   text-align: center;
                   padding: 20px;
                   margin:0 auto;
                   width: inherit;
                   height: inherit;
            
                         }            
         </style>
</head>
<body>
<%@ include file = "newheader4.jsp" %>
	 <%		
		 session.removeAttribute("userId");
		 session.removeAttribute("password");
		 session.invalidate();
	 %>
         

<div id="rcorners3" >
	 <h1>You have successfully logged out</h1>
         <% response.setHeader("Refresh", "10;url=home.jsp");
         %>
          To login again <a href="login.jsp">&nbsp;click here</a>.
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
 <%@ include file = "footer.jsp" %>        
</body>
</html>