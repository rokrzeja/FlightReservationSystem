<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<HTML>
<HEAD>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/main-web-style.css" />

	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" >
	

	<script type="text/javascript">
	
	 function check(){
		var place1 = document.getElementById('destinationPlace');
		var place2 = document.getElementById('arrivalPlace');
		console.log(place1.value);
		if (place1.value == place2.value)
		{
	  		alert("departure and arrival place are the same");
	  		return false;
		}
	 }
	
	</script>

</HEAD>
<BODY>

<div id="container">
	
		<div id="header">
			<div id="logoContainer"> <div id="logo"></div> </div>
			<a style="display:block" href="./adminpanel/main">
  				<div id="motto" style="color: black;text-align: center;font-size:40px;"> <i class="fas fa-drafting-compass fa-spin" style="color:black; font-size:70px; text-align: center; padding: 10px;"></i> ministrator control panel</div>
			</a>
		</div>
		
		<div id="main">
			<div id="mainbody">
			
				<div id="booktext"> Book a flight
				</div>
			
				<div id="fromtotext"> 
					<div id="fromtextContainer" >
						<div id="fth"></div>
						<div id="fromtext" >FROM</div>
					</div>
					<div id="totextContainer" >
						<div id="tth"></div>
						<div id="totext" >TO</div>
					</div>
				</div>
				
				<form action="processForm" method="GET" onsubmit="return check()">
				
				<div id="fromto" >
					
					<div id="fromContainer">
					<div id="from">
						<select name="destinationPlace" id="destinationPlace">
							<c:forEach var="departures" items="${departures}">
  								<option value=${departures.departurePlace }  >${departures.departurePlace }</option>
  							</c:forEach>
						</select>
					</div>
					</div>
					
					<div id="toContainer">
					<div id="to" >
					
						<select name="arrivalPlace" id="arrivalPlace">
							<c:forEach var="arrivals" items="${arrivals}">
  								<option value=${arrivals.arrivalPlace } >${arrivals.arrivalPlace }</option>
  							</c:forEach>	
						</select>
					</div>
					</div>
					
				</div>
				<div id="detailstext">
					<div id="datetextContainer">
						<div id="dth"></div>
						<div id="datetext">DEPARTURE DATE</div>
					</div>
					<div id="numberofpassangerstextContainer">
						<div id="noph"></div>
						<div id="numberofpassangerstext">NUMBER OF PASSENGERS</div>
					</div>
					<div id="classtextContainer">
						<div id="cth"></div>
						<div id="classtext">CABIN CLASS</div>
					</div>
				</div>
				<div id="details">
					<div id="dateContainer">
					<div id="dateContainer2">
					
						<input type="date" name="date" id="date" />
						<script>
						
							var today = new Date();
							var dd = today.getDate();
							var mm = today.getMonth()+1; //January is 0!
							var yyyy = today.getFullYear();
						 	if(dd<10){
						        dd='0'+dd
						    } 
						    if(mm<10){
						        mm='0'+mm
						    } 

						today = yyyy+'-'+mm+'-'+dd;
						document.getElementById("date").setAttribute("min", today);
						document.getElementById("date").setAttribute("value", today);
						
						</script>
					</div>
					</div>
					<div id="numberofpassangersContainer">
						<select name="numberOfPassangers" id="numberofpassangers">
							<option value=1> 1 passenger </option> 
							<option value=2> 2 passengers</option>
							<option value=3> 3 passengers</option>
							<option value=4> 4 passengers</option>
							<option value=5> 5 passengers</option>
							<option value=6> 6 passengers</option>
							<option value=7> 7 passengers</option>
							<option value=8> 8 passengers</option>
						</select>
					</div>
					<div id="classContainer">
					<div id="classContainer2">
						<select name="flightClass" id="class">
							<option value="Economy"> Economy </option>
							<option value="Business"> Business </option>
							<option value="First"> First </option>
						</select>
					</div>
					</div>
				</div>
		
				<div id="bottomContainer">
					<div id="leftbottomContainer" ></div>
					<div id="rightbottomContainer">
						<input type="submit" value="search" id="submit"/>
					</div>
				</div>
		
				</form>
			</div>
		</div>
		<div id="downContainer">
			<div id="info" style="width: 70%;min-height: 200px;margin: auto;color: grey;font-family: Arial, Helvetica, sans-serif;"> This project simulate reservation flight system. As client view, and also as admin view (clicked Administrator panel). All data are stored in database (structure of it is down site). If you find any problem please send me a message - r.okrzeja@wp.pl. However, if you trying to find your flight, SELECT DATES IN MARCH. Before you go next or add return flight remember to CLICK SELECT, because system have to know it.Fell free to add or delete new data. Sometimes its impossible, but don't worry system will handle it. Enjoy you flight ;) </div>
			<div id="pic" style="width: 60%;min-height: 600px;margin: auto;background-image: url('${pageContext.request.contextPath}/resources/img/database.png');background-size: cover;"></div>
		</div>
	</div>


</BODY>


</HTML>