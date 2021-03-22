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
			<div id="text"> Arrivals </div>
			<div id="buttonandhrefContainer">
				<div id="top2"></div>
				<div id="addbuttonContainer">
					<input type="button" value="add Arrival" id="addbutton" onclick="window.location.href='showFormForAddArrival'; return false;" />
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
				<th style="background:#e9e90e;"> Id</th>
				<th style="background:#e9e90e;"> Arrival Place</th>
				<th style="background:#e9e90e;"> Country </th>
				<th style="background:#e9e90e;"> Action </th>
				
			</tr>
			
			<c:forEach var="tempArrival" items="${arrivals }" >
			
			<c:url var="deleteLink" value="/adminpanel/arrivalDelete"> 
				<c:param name="arrivalId" value="${tempArrival.id }" />
			</c:url>
			
				<tr>
					<td> ${tempArrival.id } </td>
					<td> ${tempArrival.arrivalPlace } </td>
					<td> ${tempArrival.arrivalCountry } </td>
					<td>
					<a href="${deleteLink}" > Delete </a>
					</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>

</BODY>
</HTML>