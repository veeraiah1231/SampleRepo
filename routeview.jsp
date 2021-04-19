<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Routes</title>
</head>
<body>
	<%-- User Id : ${userId} --%>
	<form action="routes" method="post">
	
		<table style="with: 80%">
			<tr>
				<td>Id</td>
				<td>Source</td>
				<td>Destination</td>
				<td>Duration</td>
			</tr>
		
			<c:forEach items="${rList}" var="route">
				<tr>
				  <td><input type="hidden" name="routeId" value=${route.routeId}>${route.routeId}</td>
					<td>${route.source}</td>
					<td>${route.destination}</td>
					<td>${route.duration}</td>
					<input type="hidden" name="userId" value=${userId}>
					<input type=hidden name="action" value="saveRides"/>
					<td><input value="Book" type="submit" /></td>
					
				</tr>
				
			</c:forEach>

		</table>
	</form>

</body>
</html>