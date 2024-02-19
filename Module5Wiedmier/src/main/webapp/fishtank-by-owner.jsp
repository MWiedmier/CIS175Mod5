<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Fish Tank</title>
</head>
<body>
	<h1>Fish Tanks</h1>
	<form method = "post" action = "fishTankNavigationServlet"> 
		<table> 
			<c:forEach items="${requestScope.allTanks}" var="currenttank"> 
				<tr> 
					<td><input type="radio" name="id" value="${currenttank.id}"></td> 
					<td><h2>${currenttank.fishTankName}</h2></td></tr> 
				<tr><td colspan="3">Owner: ${currenttank.owner.ownerName}</td></tr> 
			<c:forEach var = "listVal" items = "${currenttank.listOfFish}"> 
				<tr><td></td><td colspan="3">${listVal.species}, ${listVal.numOfFish}</td></tr> 
			</c:forEach> 
			</c:forEach> 
		</table> 
		<input type = "submit" value = "edit" name="doThisToTank"> 
		<input type = "submit" value = "delete" name="doThisToTank"> 
		<input type="submit" value = "add" name = "doThisToTank"> 
	</form>
	<a href="addFishForListServlet">Create a new Tank</a> 
	<a href="index.html">Insert a new fish</a>
</body>
</html>