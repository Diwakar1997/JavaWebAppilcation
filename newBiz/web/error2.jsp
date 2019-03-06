<%-- 
    Document   : error2
    Created on : 24 May, 2018, 3:56:33 PM
    Author     : diwakar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title> Error Page</title>
        <style>
             #rcorners3 {
                   border-radius: 15px 50px;
                   background: lightsalmon;
                   text-align: center;
                   padding: 20px;
                   margin:0 auto;
                   width: inherit;
                   height: inherit;
            
                         }             
         </style>
    </head>
        <body background="images/backplace.jpg">
            <%@ include file = "newheader4.jsp" %>
         <div id="rcorners3" >
        <h1>Error !</h1><br>
        <h2>SponseId does not exist</h2>
        <% response.setHeader("Refresh", "5;url=home.jsp");
         %>
         To Register again <a href="register.jsp">&nbsp;click here</a>.
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

         
         <%@ include file = "footer.jsp" %>
    </body>
</html>
