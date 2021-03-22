<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<HTML>
<HEAD>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/place-panel.css" />

</HEAD>
<BODY>

	<div id="container" >
		<div id="header">
			<div id="top"> ${answear }</div>
			<div id="text"> Flights </div>
			<div id="buttonandhrefContainer">
				<div id="top2"></div>
				<div id="addbuttonContainer">
					<input type="button" value="add Flight" id="addbutton" onclick="window.location.href='showFormForAddFlight'; return false;" />
				</div>
				<div id="back" >
					<a href="./main"> back to main panel</a>
				</div>
			</div>
		</div>
		<hr>
		<br><br>
		<div id="maincontent">
	
		<table>
			<tr>
				<th style="background :rgb(7, 74, 175);"> Id</th>
				<th style="background :rgb(7, 74, 175);"> Flight Number</th>
				<th style="background :rgb(7, 74, 175);"> From </th>
				<th style="background :rgb(7, 74, 175);"> To </th>
				<th style="background :rgb(7, 74, 175);"> Date </th>
				<th style="background :rgb(7, 74, 175);"> Departure Time </th>
				<th style="background :rgb(7, 74, 175);"> Arrival Time </th>
				<th style="background :rgb(7, 74, 175);"> Price </th>
				<th style="background :rgb(7, 74, 175);"> Action </th>
				
			</tr>
			
			<c:forEach var="tempFlight" items="${flights}" >
			
			<c:url var="deleteLink" value="/adminpanel/flightDelete"> 
				<c:param name="flightId" value="${tempFlight.id }" />
			</c:url>
			
				<tr>
					<td> ${tempFlight.id } </td>
					<td> ${tempFlight.flightNumber } </td>
					<td> ${tempFlight.departure.departurePlace } </td>
					<td> ${tempFlight.arrival.arrivalPlace } </td>
					<td> ${tempFlight.departureDate } </td>
					<td> ${tempFlight.departureTime } </td>
					<td> ${tempFlight.arrivalTime } </td>
					<td> ${tempFlight.flightPrice } </td>
					<td>
					<a href="${deleteLink}"> Delete </a>
					</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>

</BODY>
</HTML>