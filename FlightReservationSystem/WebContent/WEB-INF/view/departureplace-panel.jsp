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
			<div id="text"> Departures </div>
			<div id="buttonandhrefContainer">
				<div id="top2"></div>
				<div id="addbuttonContainer">
					<input type="button" value="add Departure" id="addbutton" onclick="window.location.href='showFormForAddDeparture'; return false;" />
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
				<th style="background:#db0000"> Id</th>
				<th style="background:#db0000"> Departure Place</th>
				<th style="background:#db0000"> Country </th>
				<th style="background:#db0000"> Action </th>
				
			</tr>
			
			<c:forEach var="tempDeparture" items="${departures }" >
			
			<c:url var="deleteLink" value="/adminpanel/departureDelete"> 
				<c:param name="departureId" value="${tempDeparture.id }" />
			</c:url>
			
				<tr>
					<td> ${tempDeparture.id } </td>
					<td> ${tempDeparture.departurePlace } </td>
					<td> ${tempDeparture.departureCountry } </td>
					<td>
					<a href="${deleteLink}" onclick="return check();"> Delete </a>
					</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>

</BODY>
</HTML>