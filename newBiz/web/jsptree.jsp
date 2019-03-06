<%@ taglib uri="/WEB-INF/tree-descriptor.tld" prefix="showtree"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tree View</title>
<style>
ul.tree, ul.tree ul { 
	list-style-type: none; 
	background: url(images/picture-verticaline.png) repeat-y; 
	margin: 0; padding: 0; 
 }

ul.tree ul { 
	margin-left: 10px; 
 }

ul.tree li { 
	margin: 0; 
	padding: 0 12px; 
	line-height: 20px; 
	background: url(images/picture-currentnode.png) no-repeat; 
	color: #369; 
	font-weight: bold; 
} 

ul.tree li:last-child { 
 background: #fff url(images/picture-lastnode.png) no-repeat; 
}

td {
	color: maroon;
	font-family: Tahoma, Verdana;
	font-size: 10pt;
	font-weight: bold;
	text-decoration: none;
}

font {
	color: green;
	font-family: Tahoma, Verdana;
	font-size: 10pt;
	font-weight: bold;
	text-decoration: none;

}
</style>

<script type="text/javascript">
	function toggle(id) {
		var e = document.getElementById(id);
		if (e.style.display == '')
			e.style.display = 'none';
		else
			e.style.display = '';
	}
	
	
</script>

</head>
<body background="images/backplace.jpg">
<%@ include file = "newheader3.jsp" %>
<%  String sponseID = user.getRegisterId(); 
%>
	<center>
		<table>
			<tr>
				<td bgcolor="#FFCCFF" align="left"><h1>See your Clients</h1></td>
			</tr>
			<tr>
				<td><br></td>	
				<td><br></td>					
			</tr>
			<tr>
                            <td>	<showtree:jsptree  name="<%=sponseID %>"  /></td>
				<td></td>
			</tr>
		</table>
	</center>
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