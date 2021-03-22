<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<HEAD>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/step-second.css" />

	<script type="text/javascript">
		// select the button
		function changeVal(){
			var v = document.getElementById("select").value;
			document.getElementById("select").value = "selected";
		}
		
		// check if button is selected and return next page
		function check(path){
			var v = document.getElementById("select").value;
			if(v != "selected") alert("You do not select the flight");
			else window.location.href=path;
		}
	</script> 

</HEAD>
<body>		
	
	<div id="container">
	
		<div id="header">
			<div id="logoContainer"> <div id="logo"></div> </div>
			<div id="motto"> </div>
		</div>
		
		<div id="main">
			<div id="mainbody" style="border-top-left-radius: 25px;border-top-right-radius: 25px;opacity: 0.85;margin: auto;min-height: 300px;width: 70%;background: #0000CD;">
				<div id="departureflight">
					<div id="departure">${flight.departure.departurePlace }</div>
					<div id="space" > &#10132 </div>
					<div id="arrival">${flight.arrival.arrivalPlace }</div>
				</div>
				<div id="dateandclass">
					<div id="date">date:  ${flight.departureDate }	</div>
					<div id="class">class:    ${flightClass } </div>
				</div>
				<div id="hoursandprice">
					<div id="hours"> ${flight.departureTime} - ${flight.arrivalTime}</div>
					<div id="price"> ${price }</div>
					<div id="plnContainer"> 
						<div id="plnup"></div>
						<div id="pln"> PLN</div>
					</div>
				</div>
				<div id="flightnumberandselect">
					<div id="flightnumber">flight nr: ${flight.flightNumber } &#9992 </div>
					<div id="nextdateinfoContainer">
						<div id="ndih"></div>
						<div id="nextdateinfo" style="color: white"> &#8595 next available flights &#8595</div>
					</div>
					<div id="selectbutton" > 
						<input type="button" id="select" value="select" onclick="changeVal()">
					</div>
				</div>
			</div>
			<div id="bodydates" style="background: white";>
				<div id="date0" style="border-bottom-left-radius: 25px;">
					<div id="spc"></div>
					<div id="dy0" style="color: white;"></div>
					<div id="spc"></div>
					<div id="prc" style="width: 100%; min-height: 40px;">
						<div id="lprc0" style="float: left; width: 48%;min-height: 40px;color: white; font-Size:x-large; text-Align:right;"> ${price } </div>
						<div id="mprc" style="float: left; width: 4%;min-height: 40px;"></div>
						<div id="rprc" style="float: right;width: 48%;min-height: 40px;">
							<div id="topprc" style="min-height: 10px;"></div>
							<div id="prcpln0" style="min-height: 30px;color: white;text-Align:left;">PLN</div>
						</div>
					</div>
				</div>
				<a id="datehref1">
				<div id="date1" style="float:left;width:20%;min-height:70px;text-Align:center;">
					<div id="spc"></div>
					<div id="dy1"></div>
					<div id="spc"></div>
					<div id="prc" style="width: 100%; min-height: 40px;">
						<div id="lprc1" style="float: left; width: 48%;min-height: 40px;color: #0000CD; font-Size:x-large; text-Align:right;"> </div>
						<div id="mprc" style="float: left; width: 4%;min-height: 40px;"></div>
						<div id="rprc" style="float: right;width: 48%;min-height: 40px;">
							<div id="topprc" style="min-height: 10px;"></div>
							<div id="prcpln1" style="min-height: 30px;color: #0000CD;text-Align:left;"></div>
						</div>
					</div>
				</div>
				</a>
				<a id="datehref2">
				<div id="date2" style="float:left;width:20%;min-height:70px;text-Align:center;">
					<div id="spc"></div>
					<div id="dy2"></div>
					<div id="spc"></div>
					<div id="prc" style="width: 100%; min-height: 40px;">
						<div id="lprc2" style="float: left; width: 48%;min-height: 40px;color: #0000CD; font-Size:x-large; text-Align:right;"></div>
						<div id="mprc" style="float: left; width: 4%;min-height: 40px;"></div>
						<div id="rprc" style="float: right;width: 48%;min-height: 40px;">
							<div id="topprc" style="min-height: 10px;"></div>
							<div id="prcpln2" style="min-height: 30px;color: #0000CD;text-Align:left;"></div>
						</div>
					</div>
				</div>
				</a>
				<a id="datehref3">
				<div id="date3" style="float:left;width:20%;min-height:70px;text-Align:center;">
					<div id="spc"></div>
					<div id="dy3"></div>
					<div id="spc"></div>
					<div id="prc" style="width: 100%; min-height: 40px;">
						<div id="lprc3" style="float: left; width: 48%;min-height: 40px;color: #0000CD; font-Size:x-large; text-Align:right;"> </div>
						<div id="mprc" style="float: left; width: 4%;min-height: 40px;"></div>
						<div id="rprc" style="float: right;width: 48%;min-height: 40px;">
							<div id="topprc" style="min-height: 10px;"></div>
							<div id="prcpln3" style="min-height: 30px;color: #0000CD;text-Align:left;"></div>
						</div>
					</div>
				</div>
				</a>
				<a id="datehref4">
				<div id="date4" style="float:left;width:20%;min-height:70px;text-Align:center;">
					<div id="spc"></div>
					<div id="dy4"></div>
					<div id="spc"></div>
					<div id="prc" style="width: 100%; min-height: 40px;">
						<div id="lprc4" style="float: left; width: 48%;min-height: 40px;color: #0000CD; font-Size:x-large; text-Align:right;"></div>
						<div id="mprc" style="float: left; width: 4%;min-height: 40px;"></div>
						<div id="rprc" style="float: right;width: 48%;min-height: 40px;">
							<div id="topprc" style="min-height: 10px;"></div>
							<div id="prcpln4" style="min-height: 30px;color: #0000CD;text-Align:left;"></div>
						</div>
					</div>
				</div>
				</a>
				<script type="text/javascript">
					var quantity = 0;
					var wholequantity = ${length};
					console.log('quantity' + quantity);
					console.log('wholequantity' + wholequantity);
					var fullprice = ${flight.flightPrice} * ${numberOfPassangers};
					if(wholequantity == 0)
						{
							var divspc = document.getElementById('date0');
							divspc.style.height = '20px';
							divspc.style.width = '100%';
												
							var div = document.getElementById('date1');
							div.style.height = '50px';
							div.style.textAlign = 'center';
							div.style.fontSize = "x-large";
							div.style.width = '100%';
							div.innerHTML = "There is no more available flights";
							div.style.color = "#0000CD";
							
							for(var i=2; i<5; i++){
							var rmv = document.getElementById('date' + i);
							rmv.remove();
							}
							
							quantity = 6;
						}
					else{
						var div = document.getElementById('date'+ quantity);
						div.style.height = '70px';
						div.style.textAlign = 'center';
		    			div.style.cssFloat = 'left';
		    			div.style.width = '20%';
		    			div.style.background="#0000CD";
		    			
		    			var dejt = "";
				    	
				    	const birthday = new Date('${flight.departureDate}');
				    	const day = birthday.getDay();
				    	if(day == 1) dejt = "Mon ";
				    	if(day == 2) dejt = "Tue ";
				    	if(day == 3) dejt = "Wed ";
				    	if(day == 4) dejt = "Thu ";
				    	if(day == 5) dejt = "Fri ";
				    	if(day == 6) dejt = "Sat ";
				    	if(day == 0) dejt = "Sun ";
				    	
				    	var temp = "${flight.departureDate}";
				    	dejt = dejt + temp.substr(5, 9);
				    	
				    	var div0 = document.getElementById('dy0');
		    			div0.innerHTML += dejt;
		    			
		    			quantity = quantity + 1;
					}
				</script>
				
				<c:forEach var="tempFlight" items="${restFlights}">
			
					<c:url var="datelink" value="/processForm2"> 
						<c:param name="destinationPlace" value="${flight.departure.departurePlace }" />
						<c:param name="arrivalPlace" value="${flight.arrival.arrivalPlace }" />
		 				<c:param name="date" value="${tempFlight.departureDate}" /> 
						<c:param name="flightClass" value="${flightClass }" />
						<c:param name="numberOfPassangers" value="${numberOfPassangers}" />
						<c:param name="firstflightnumber" value="${firstflightnumber }" />
						<c:param name="fp" value="${fp}" />
					</c:url>
				
				<script type="text/javascript">
						
						if(quantity < 5)
				    	{
							var div = document.getElementById('date'+ quantity);

					    	if(quantity%2 != 0)
					    	{
					    		div.style.background="#c8c8c8";
					    	}
					    	else
					    	{
					    		div.style.background="white";
					    	}
					    	
					    	var dejt = "";
					    	const birthday = new Date('${tempFlight.departureDate}');
					    	const day = birthday.getDay();
					    	
					    	if(day == 1) dejt = "Mon ";
					    	if(day == 2) dejt = "Tue ";
					    	if(day == 3) dejt = "Wed ";
					    	if(day == 4) dejt = "Thu ";
					    	if(day == 5) dejt = "Fri ";
					    	if(day == 6) dejt = "Sat ";
					    	if(day == 0) dejt = "Sun ";
					    	
					    	var temp = "${tempFlight.departureDate}";
					    	dejt = dejt + temp.substr(5, 9);
					    	
					    	var divprc = document.getElementById('lprc'+ quantity);
					    	divprc.innerHTML = "${price}";
					    	var divpln = document.getElementById('prcpln'+ quantity);
					    	divpln.innerHTML = "PLN";
							var divdy = document.getElementById('dy' + quantity);
							divdy.innerHTML = dejt;
					    	
							var tag = document.getElementById('datehref'+ quantity);
					    	tag.setAttribute('href',"${datelink}");
					    	
					    	quantity = quantity + 1;
						}
					</script>
				</c:forEach>
			</div>
			<div id="sum">
				<div id="fullprice"><br>Full price: ${fullprice} pln </div>
			</div>
			<div id="next">
				<c:url var="arrivalFlight" value="/client-details">
					<c:param name="flightClass" value="${flightClass }" />
					<c:param name="numberOfPassangers" value="${numberOfPassangers}" />
					<c:param name="firstflightnumber" value="${firstflightnumber}" />
					<c:param name="secondflightnumber" value="${flight.flightNumber}" />
				</c:url>
	
				<input type="submit" value="next" id="submit" onclick="check('${arrivalFlight}')" />
			</div>
			
		</div>
	</div>
	
</body>
</html>