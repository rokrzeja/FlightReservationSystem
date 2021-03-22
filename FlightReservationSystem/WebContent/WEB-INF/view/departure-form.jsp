<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

	<title> Save Departure </title>	  

</head>
<body>

	<div id="wrapper">
		<div id="header">
		</div>	
	</div>
	
	<div id="container" >
		<h3> Save Departure</h3>
	
		<form:form action="saveDeparture" modelAttribute="departure" method="POST">
		
		<form:hidden path="id"/>
		
			
			Arrival place:<form:input path="departurePlace" />
						<form:errors path="departurePlace" style="color: red;" />
					<br><br>
			Arrival Country:<form:input path="departureCountry" />
						<form:errors path="departureCountry" style="color: red;" />
					<br><br>
			<input type="submit" value="Save" class="save" />
					
					
		</form:form>
		
		
		<p>
			<a href="${pageContext.request.contextPath}/adminpanel/departureplacepanel">Back to list</a>
		</p>
	
	</div>


</body>
</html>