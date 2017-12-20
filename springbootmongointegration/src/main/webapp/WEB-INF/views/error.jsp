<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Error Page</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript" src="<c:url value="/js/jquery-1.12.3.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery-ui.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.tabs.js" />"></script>
	<link rel="stylesheet" href="<c:url value="/css/jquery-ui.css" />">
	<link rel="stylesheet" href="<c:url value="/css/jquery.ui.tabs.css" />">
	<link rel="stylesheet" href="<c:url value="/css/jquery.ui.theme.css" />">
	<link rel="stylesheet" href="<c:url value="/css/style.css" />">
</head>
	<script>	
	  $(function() {
		    $( "#tabs" ).tabs();
		});
	</script>
<body>

<div id="tabs" class="tabs">
<div><table width="550">
<tbody>
	<tr>
		<center><td><h2>Error Page</h2></center></td>
	</tr>
</table>
</div>
  <ul>
    <li><a href="#tabs-1">Error Page</a></li>
  </ul>
<div id="tabs-1" class="tabs-1">
<br>
<h3>${error}</h3>
<br><br>
<center><a href="<c:url value='/articles/' />" ><button type="button" id="mybutton" >Home</button></a></center>
</div>
</div>

</body>
</html>