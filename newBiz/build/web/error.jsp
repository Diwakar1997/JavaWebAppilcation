<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Error Page</title>
<style>
             #rcorners3 {
                   border-radius: 15px 50px;
                   background: lightcoral;
                   text-align: center;
                   padding: 20px;
                   margin:0 auto;
                   width:inherit;
                   height:inherit;
            
                         }             
         </style>
</head>
<body background="images/backplace.jpg">
    <%@ include file = "newheader4.jsp" %>
   <div id="rcorners3" >
     <h1>Username Or Password is incorrect</h1><br>
	 Please login again <a href="login.jsp">click here</a>.
         
         <% response.setHeader("Refresh", "5;url=login.jsp");
         %>
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
