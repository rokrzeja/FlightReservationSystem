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
			<div id="text"> Clients </div>
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
					<th style="background: orange;"> First Name</th>
					<th style="background: orange;"> Last Name</th>
					<th style="background: orange;"> Sex </th>
					<th style="background: orange;"> Birthday </th>
					<th style="background: orange;"> Birthplace </th>
					<th style="background: orange;"> Phone number </th>
					<th style="background: orange;"> Email </th>
				</tr>
			
				<c:forEach var="tempClient" items="${clients }" >
					<tr>
						<td> ${tempClient.firstName } </td>
						<td> ${tempClient.lastName } </td>
						<td> ${tempClient.sex } </td>
						<td> ${tempClient.birthday } </td>
						<td> ${tempClient.birthplace } </td>
						<td> ${tempClient.telephoneNumber } </td>
						<td> ${tempClient.email } </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</BODY>
</HTML>