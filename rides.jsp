<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rides</title>
</head>
<body>
	
	
	
		<table style="with: 80%">
			<tr>
				<td>Id</td>
				<td>User Id</td>
				<td>Route Id</td>
				<td>Date</td>
			</tr>
		
			<c:forEach items="${myRides}" var="rides">
				<tr>
				 	<td>${rides.rideId}</td>
					<td>${rides.userId}</td>
					<td>${rides.routeId}</td>
					<td>${rides.dateTime}</td>
					
				</tr>
				
			</c:forEach>

		</table>
 

</body>
</html>