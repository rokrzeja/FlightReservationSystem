<!DOCTYPE html>
<HTML>
<HEAD>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/admin-panel.css" />	
		  
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
	<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</HEAD>
<BODY>

	<div id="container" >
	
		<div id="header" >
			<div id="top" ></div>
			<div id="headtext">Administrator Control Panel</div>
		</div>
		<hr>
		<div id="mainContainer">
			<div id="space"></div>
			<div id="clientContainer">
				<div id="client">
					<div id="iconandname">
						<div id="enter"></div>
						<div id="icon"> <i class='fas fa-user-alt'></i></div>
						<div id="name">Client</div>
					</div>
					<a href="./clientpanel" >
						<div id="menagethem">
							<div id="up"></div>
							<div id="text" style="color:orange;"> Menage Them</div>
							<div id="littleicon" style="color:orange;"><i class="fa fa-arrow-circle-right"></i></div>
						</div>
					</a>
				</div>
			</div>
			<div id="space"></div>
			<div id="reservationContainer">
				<div id="reservation">
					<div id="iconandname">
						<div id="enter"></div>
						<div id="icon"> <i class="fas fa-book-open"></i></div>
						<div id="name">Reservation</div>
					</div>
					<a href="./reservationpanel" >
						<div id="menagethem">
							<div id="up"></div>
							<div id="text" style="color:#09c332;"> Menage Them</div>
							<div id="littleicon" style="color:#09c332;"><i class="fa fa-arrow-circle-right"></i></div>
						</div>
					</a>
				</div>
			</div>
			<div id="space"></div>
			<div id="flightContainer">
				<div id="flight">
					<div id="iconandname">
						<div id="enter"></div>
						<div id="icon" > <i class="fas fa-plane"></i></i></div>
						<div id="name">Flight</div>
					</div>
					<a href="./flightpanel" >
						<div id="menagethem">
							<div id="up"></div>
							<div id="text" style="color:rgb(7, 74, 175);"> Menage Them</div>
							<div id="littleicon" style="color:rgb(7, 74, 175);"><i class="fa fa-arrow-circle-right"></i></div>
						</div>
					</a>
				</div>
			</div>
			<div id="space"></div>
			<div id="departureContainer">
				<div id="departure">
					<div id="iconandname">
						<div id="enter"></div>
						<div id="icon"> <i class="fas fa-plane-departure"></i></div>
						<div id="name">Departure</div>
					</div>
					<a href="./departureplacepanel" >
						<div id="menagethem">
							<div id="up"></div>
							<div id="text" style="color:#db0000"> Menage Them</div>
							<div id="littleicon" style="color:#db0000"><i class="fa fa-arrow-circle-right"></i></div>
						</div>
					</a>
				</div>
			</div>
			<div id="space"></div>
			<div id="arrivalContainer">
				<div id="arrival">
					<div id="iconandname">
						<div id="enter"></div>
						<div id="icon"> <i class="fas fa-plane-arrival"></i></div>
						<div id="name">Arrival</div>
					</div>
					<a href="./arrivalplacepanel" >
						<div id="menagethem">
							<div id="up"></div>
							<div id="text" style="color:#e9e90e;"> Menage Them</div>
							<div id="littleicon" style="color:#e9e90e;"><i class="fa fa-arrow-circle-right"></i></div>
						</div>
					</a>
				</div>
			</div>
			<div id="space"></div>
		</div>
		<div id="down">
			<div id="upup"></div>
			<div id="left"></div>
			<div id="right">
				<a href="../../list"> back to client panel</a>
			</div>
		</div>
		
	</div>
</BODY>
</HTML>