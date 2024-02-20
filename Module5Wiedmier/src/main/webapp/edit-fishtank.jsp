<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Fish Tank</title>
</head>
<body>
	<h1>Edit Fish Tank</h1>
	<form action = "editFishTankServlet" method="post"> 
		<input type ="hidden" name = "id" value= "${fishTankToEdit.id}"> 
		Tank Name: <input type="text" name="tankName" value="${fishTankToEdit.fishTankName}"><br />  
		Shopper Name: <input type = "text" name = "ownerName" value="${fishTankToEdit.owner.ownerName}"><br /> 
		Available Items:<br /> 
		<select name="allFish" multiple size="6"> 
		<c:forEach items="${requestScope.allFish}" var="currentfish"> 
		<option value="${currentfish.id}">${currentfish.species} | 
		${currentfish.numOfFish}</option> 
		</c:forEach> 
		</select> 
		<br /> 
		<input type = "submit" value="Edit Tank and Add Fish"> 
	</form> 
	<a href = "index.html">Go add new items instead.</a>
</body>
</html>