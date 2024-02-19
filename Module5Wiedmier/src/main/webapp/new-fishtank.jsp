<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Fish Tank</title>
</head>
<body>
	<h1>New Fish Tank</h1>
	<form action = "createNewTankServlet" method="post"> 
		Tank Name: <input type ="text" name = "tankName"><br /> 
		Owner Name: <input type = "text" name = "ownerName"><br /> 
		Available Fish:<br /> 
		<select name="allFishToAdd" multiple size="6"> 
			<c:forEach items="${requestScope.allFish}" var="currentfish"> 
			<option value = "${currentfish.id}">${currentfish.species} | ${currentfish.numOfFish}</option> 
			</c:forEach> 
		</select> 
		<br /> 
		<input type = "submit" value="Create Tank and Add Fish"> 
	</form>
	<a href = "index.html">Go add new fish instead.</a>
</body>
</html>