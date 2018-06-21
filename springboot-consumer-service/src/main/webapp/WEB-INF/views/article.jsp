<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Article Page</title>
	<script type="text/javascript" src="<c:url value="/js/jquery-1.12.3.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.dataTables.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery-ui.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.tabs.js" />"></script>
	<link rel="stylesheet" href="<c:url value="/css/jquery-ui.css" />">
	<link rel="stylesheet" href="<c:url value="/css/jquery.ui.tabs.css" />">
	<link rel="stylesheet" href="<c:url value="/css/jquery.ui.theme.css" />">
	<link rel="stylesheet" href="<c:url value="/css/jquery.dataTables.css" />">
	<link rel="stylesheet" href="<c:url value="/css/jquery.dataTables_themeroller.css" />">
	<link rel="stylesheet" href="<c:url value="/css/eeherald.css" />">
	<link rel="stylesheet" href="<c:url value="/css/style.css" />">
	<style type="text/css">
		.error { color: #ff0000; font-style: italic; font-size: x-small;}
	</style>
	<script>	
	  $(function() {
		    $( "#tabs" ).tabs();
		});
	</script>
	<script type="text/javascript">
		$(document).ready( function () 
		{
			$('#articleTable').dataTable({
			"bJQueryUI": true,
			"sPaginationType": "full_numbers",
			"aLengthMenu": [ [5, 10, 25, 50, -1], [5, 10, 25, 50, "All"] ],
			"iDisplayLength": 5
			});
		});
	</script>
</head>
<body>

<c:url var="addAction" value="/article/add" ></c:url>

<div id="main" style="width:900px;"><br><table width="550">
<tbody>
	<tr>
		<td align="right"><h2>Welcome To Article Page</h2></td>
	</tr>
</table>
</div>
<div id="tabs" class="tabs" style="width:900px;">
  <ul>
    <li><a href="#tabs-1">Article Page</a></li>
  </ul>
<div id="tabs-1" class="tabs-1">

<div>
<h3>
	Add/Edit Article
</h3>
<form:form action="${addAction}" commandName="article">
<table>
	<c:if test="${article.articleID > 0}">
	<tr>
		<td>
			<form:label path="articleID">
				<spring:message text="Article ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="articleID" readonly="true" size="8"  disabled="true" />
			<form:hidden path="articleID" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="articleTitle">
				<spring:message text="Article Title"/>
			</form:label>
		</td>
		<td>
			<form:input path="articleTitle" cssStyle="width:400px;"/>
			<form:errors path="articleTitle" cssClass="error"/>
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="description" >
				<spring:message text="Article Description"/>
			</form:label>
		</td>
		<td>
			<form:textarea path="description" rows="5" cols="30" cssStyle="width:400px;" />
			<form:errors path="description" cssClass="error"/>
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="news" >
				<spring:message text="Article Type"/>
			</form:label>
		</td>
		<td>
			<form:select path="news">
				<c:choose>
		            <c:when test="${!empty article.news}">
		                <form:option value="${article.news}" label="${article.news}" selected="true" />
		                <form:options items="${news}"/>
		            </c:when>
		            <c:otherwise>
		                <form:option value="" label="---Select Article Type---" />
		                <form:options items="${news}"/>
		            </c:otherwise>
		        </c:choose> 
			</form:select>
			<form:errors path="news" cssClass="error"/>
		</td> 
	</tr>
	<c:if test="${!empty articleStatus && articleStatus ne null && article.articleID > 0}">
	<tr>
		<td>
			<form:label path="articleStatus" >
				<spring:message text="Article Status"/>
			</form:label>
		</td>
		<td>
			<form:select path="articleStatus">
		        <form:option value="" label="---Select Article Status---" />
				<form:options items="${articleStatus}"/>
			</form:select>
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:hidden path="version" />
		</td>
		<td>
			<form:hidden path="edited" />
		</td>
		<td>
			<form:hidden path="published" />
		</td>
		<td>
			<form:hidden path="QA" />
		</td> 
	</tr>
	<tr>
		<td colspan="2" align="center">
			<c:if test="${article.articleID > 0}">
				<input type="submit" name="save" value="<spring:message text="Update Article"/>" />
				<input type="submit" name="cancel" value="<spring:message text="Cancel Update"/>" 
					onclick="return confirm('Are you sure you want to cancel?')"/>
			</c:if>
			<c:if test="${article.articleID eq 0}">
				<input type="submit" name="save" value="<spring:message text="Add Article"/>"/>
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
</div>
</div>
</div>
<div id="data" class="data" style="width:900px;">
<c:if test="${!empty listArticles}">
<h3>Article List</h3>
	<table id="articleTable" cellpadding="0" cellspacing="0" border="2" width="100%" bordercolor="black" bgcolor="#F0F0F0">
	<thead>
	<tr>
		<th width="80">Article ID</th>
		<th width="120">Article Title</th>
		<th width="100">Article Description</th>
		<th width="80">Article Type</th>
		<th width="80">Article Status</th>
		<th width="60">Edit</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${listArticles}" var="article">
		<tr>
			<td>${article.articleID}</td>
			<td>${article.articleTitle}</td>
			<td><textarea name=description id='description' rows="5" cols="30" readonly="readonly"><c:out value="${article.description}" /></textarea></td>
			<td>${article.news}</td>
			<td>${article.articleStatus}</td>			
			<td><a href="<c:url value='/edit/${article.articleID}' />" ><button type="button" id="mybutton">Edit</button></a></td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
</c:if>
</div>
<br><br>

</body>
</html>
