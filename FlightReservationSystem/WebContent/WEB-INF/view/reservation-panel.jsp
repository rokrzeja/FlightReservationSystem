<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<HTML>
<HEAD>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/client-panel-style.css" />

</HEAD>
<BODY>

	<div id="container" >
	
		<div id="header">
			<div id="top"></div>
			<div id="text"> Reservations </div>
			<div id="motto" > 
				<div id="top2"></div>
				<div id="back">
					<a href="./main"> back to main panel</a>
				</div>
			</div>
		</div>
		<hr>
		<br><br>
		<div id="maincontent">
	
		<table>
			<tr>
				<th style="background: #09c332;"> Id</th>
				<th style="background: #09c332;"> Cabin class</th>
				<th style="background: #09c332;"> Flight Id </th>
				<th style="background: #09c332;"> Flight Number </th>
				<th style="background: #09c332;"> From </th>
				<th style="background: #09c332;"> To </th>
				<th style="background: #09c332;"> Client Id </th>
				<th style="background: #09c332;"> Client Last Name
				<th style="background: #09c332;"> Number Of Passengers </th>
				<th style="background: #09c332;"> Full Price </th>
			</tr>
			
			<c:forEach var="tempReservation" items="${reservations }" >
				<tr>
					<td> ${tempReservation.id } </td>
					<td> ${tempReservation.flightClass } </td>
					<td> ${tempReservation.flight.id } </td>
					<td> ${tempReservation.flight.flightNumber } </td>
					<td> ${tempReservation.flight.departure.departurePlace} </td>
					<td> ${tempReservation.flight.arrival.arrivalPlace} </td>
					<td> ${tempReservation.client.id } </td>
					<td> ${tempReservation.client.lastName } </td>
					<td> ${tempReservation.numberOfPassangers } </td>
					<td> ${tempReservation.fullPrice } </td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>

</BODY>
</HTML>