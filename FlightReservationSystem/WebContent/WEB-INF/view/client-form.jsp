<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<HTML>
<HEAD>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/client-form.css" />

</HEAD>
<BODY>

	<div id="container">
	
		<div id="header">
			<div id="logoContainer"> <div id="logo"></div> </div>
			<div id="motto"> </div>
		</div>
		
		<div id="main">
			<div id="mainbody">
				<form action="save" method="POST" >
					
					<div id="sexContainer" >
						<div id="male">
							<input type="radio" name="sex" value="Male" /> Male 
						</div>
						<div id="female">
							<input type="radio" name="sex" value="Female" required/> Female
						</div>
					</div>
					
					<div id="firstnametext" >
						<label>First name </label>
					</div>
					<div id="firstname">
						<input type="text" name="firstname" id="firstname" minlength="2" maxlength="24" pattern="[a-zA-Z]{2,24}" required/>
					</div>
					
					<div id="space"></div>
	
					<div id="lastnametext">
						<label>Last name </label>
					</div>
					<div id="lastname">
						<input type="text" name="lastname" id="lastname" minlength="2" maxlength="24" pattern="[a-zA-Z]{2,24}" required/>
					</div>
					
					<div id="space"></div>
	
					<div id="birthdaytext">
						<label>Birthday </label>
					</div>
					<div id="birthdayy">
						<input type="date" id="birthday" name="birthday" required/>	
						
						<script>
						
							var todaymax = new Date();
							var todaymin = new Date();
							var dd = todaymax.getDate();
							var mm = todaymax.getMonth()+1; //January is 0!
							var yyyy = todaymax.getFullYear()-18;
						 	if(dd<10){
						        dd='0'+dd
						    } 
						    if(mm<10){
						        mm='0'+mm
						    } 

							todaymax = yyyy+'-'+mm+'-'+dd;
							todaymin = 1900+'-'+mm+'-'+dd;
							document.getElementById("birthday").setAttribute("max", todaymax);
							document.getElementById("birthday").setAttribute("min", todaymin);
						</script>	
					</div>
	
					<div id="space"></div>
	
					<div id="birthplacetext">
						<label>Birthplace </label>
					</div>
					<div id="birthplace">
						<input type="text" name="birthplace" id="birthplace" minlength="2" maxlength="24" pattern="[a-zA-Z]{2,24}" required/>				
					</div>
					
					<div id="space"></div>
					
					<div id="tnt">
						<label>Telephone number </label>
					</div>
					<div id="telephonenumber">
						<input type="number" name="telephonenumber" id="telephonenumber" value="000000000" min="100000000" max="999999999" required/>
					</div>
	
					<div id="space"></div>
					
					<div id="mailtext">
						<label>E-mail </label>
					</div>
					<div id="email">
						<input type="email" name="email" id="email" pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*$" required/>
					</div>
	
					<input type="hidden" name="flightClass" value="${flightClass }" />
					<input type="hidden" name="numberOfPassangers" value="${numberOfPassangers}" />
					<input type="hidden" name="firstflightnumber" value="${firstflightnumber}" />
					<input type="hidden" name="secondflightnumber" value="${secondflightnumber}" />
					
					<div id="space"></div>
					<div id="space"></div>
					<div id="space"></div>
					<div id="space"></div>
					<div id="space"></div>
					
					
					<div id="button">
						<div id="lb"></div>
						<input type="submit" value="book" id="submit"/>
					</div>
				</form>
	
			</div>
		</div>
	</div>
	
</BODY>
</HTML>