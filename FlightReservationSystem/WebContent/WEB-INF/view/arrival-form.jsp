<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

	<title> Save Arrival </title>	  

</head>
<body>

	<div id="wrapper">
		<div id="header">
		</div>	
	</div>
	
	<div id="container" >
		<h3> Save Arrival</h3>
	
		<form:form action="saveArrival" modelAttribute="arrival" method="POST">
		
		<form:hidden path="id"/>
		
			
			Arrival place:<form:input path="arrivalPlace" />
						<form:errors path="arrivalPlace" style="color: red;"/>
					<br><br>
			Arrival Country:<form:input path="arrivalCountry" />
						<form:errors path="arrivalCountry" style="color: red;"/>
					<br><br>
			<input type="submit" value="Save" class="save" />
					
					
		</form:form>
		
		
		<p>
			<a href="${pageContext.request.contextPath}/adminpanel/arrivalplacepanel">Back to list</a>
		</p>
	
	</div>


</body>
</html>