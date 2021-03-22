<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

	<title> Save Flight </title>	  

</head>
<body>

	<div id="wrapper">
		<div id="header">
		</div>	
	</div>
	
	<div id="container" >
		<h3> Save Flight</h3>
	
		<form:form action="saveFlight" modelAttribute="flight" method="POST">
		
		<form:hidden path="id"/>
		
			
			Flight number:<form:input path="flightNumber" />
						<form:errors path="flightNumber" style="color: red;"/>
					<br><br>
			Departure:
						<select name="departurePlace" id="departurePlace">
							<c:forEach var="departures" items="${departures}">
  								<option value=${departures.departurePlace }  >${departures.departurePlace } </option>
  							</c:forEach>
						</select>
						<br>
			Arrival
						<select name="arrivalPlace" id="arrivalPlace">
							<c:forEach var="arrivals" items="${arrivals}">
  								<option value=${arrivals.arrivalPlace }  >${arrivals.arrivalPlace } </option>
  							</c:forEach>
						</select>
						<br>
						
			Departure Date <form:input type="date" path="departureDate" />
						<form:errors path="departureDate" style="color: red;"/>
						<br><br>	
					
			Departure time:<form:input type="time" path="departureTime" />
						<form:errors path="departureTime" style="color: red;"/>
					<br><br>
					
			Arrival time: <form:input type="time" path="arrivalTime" />
						<form:errors path="arrivalTime" style="color: red;"/>
					<br><br>
			
			Price <form:input path="flightPrice" />
						<form:errors path="flightPrice" style="color: red;"/>
					<br><br>
					
			<input type="submit" value="Save" class="save" />
					
					
		</form:form>
		
		
		<p>
			<a href="${pageContext.request.contextPath}/adminpanel/flightpanel">Back to list</a>
		</p>
	
	</div>


</body>
</html>