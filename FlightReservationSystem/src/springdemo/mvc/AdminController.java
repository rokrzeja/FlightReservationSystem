package springdemo.mvc;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import springdemo.entity.Arrival;
import springdemo.entity.Client;
import springdemo.entity.Departure;
import springdemo.entity.Flight;
import springdemo.entity.Reservation;
import springdemo.service.FlightService;

@Controller
@RequestMapping("/adminpanel")
public class AdminController {
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping("/main")
	public String showAdminPanel(Model theModel) {
		
		return "admin-panel";
	}
	
	
	@GetMapping("/clientpanel")
	public String showClientPanel(Model theModel) {
		
		List <Client> clients = flightService.getClients();
		
		theModel.addAttribute("clients", clients);
		
		return "client-panel";
	}
	
	@GetMapping("/reservationpanel")
	public String showReservationPanel(Model theModel) {
		
		List <Reservation> reservations = flightService.getReservations();
		
		theModel.addAttribute("reservations", reservations);
		
		return "reservation-panel";
	}
	
	
// FLIGHT	
	
	@GetMapping("/flightpanel")
	public String showFlightPanel(Model theModel) {
		
		List <Flight> flights = flightService.getFlights();
		
		theModel.addAttribute("flights", flights);
		
		return "flight-panel";
	}
	
	@GetMapping("/showFormForAddFlight")
	public String showFormForAddFlight(Model model) {
		
		List <Departure> theDepartures = flightService.getDeparturePlaces();
		model.addAttribute("departures", theDepartures);
		
		List <Arrival> theArrivals = flightService.getArrivalPlaces();
		model.addAttribute("arrivals", theArrivals);
		
		
		//create model attribute to bind form data
		Flight theFlight = new Flight();
		
		model.addAttribute("flight", theFlight);
		
		return "flight-form";
	}
	
	@PostMapping("/saveFlight")
	public String saveFlight(@Valid @ModelAttribute("flight") Flight theFlight, BindingResult bindingResult, Model model, 
			@RequestParam("departurePlace") String departurePlace, @RequestParam("arrivalPlace") String arrivalPlace )
	{
		List <Departure> theDepartures = flightService.getDeparturePlaces();
		model.addAttribute("departures", theDepartures);
		
		List <Arrival> theArrivals = flightService.getArrivalPlaces();
		model.addAttribute("arrivals", theArrivals);
		
		System.out.println("saveFlight: dep:" + departurePlace);
		
		Departure departure = flightService.getDeparture(departurePlace);
		Arrival arrival = flightService.getArrival(arrivalPlace);
		
		theFlight.setDeparture(departure);
		theFlight.setArrival(arrival);
		
		//check if all fields are correctly defined
		if(bindingResult.hasErrors()) return "flight-form";
		else
		{
			//save correctly defined new departure
			flightService.saveFlight(theFlight);
		
			return "redirect:/adminpanel/flightpanel";
		}
	}
	
	@GetMapping("/flightDelete")
	public String flightDelete(@RequestParam("flightId") int id, Model theModel) throws ParseException
	{
		// return true or false if delete departure is possible (actually should be boolean)
		String answear = flightService.deleteFlight(id);
		
		//if answear == true, its impossible, show information(add to model)
		if(answear == "true") 
		{
			theModel.addAttribute("answear", "Incorrect operation, you cannot delete flight which has been booked");
		}
		
		//load again all departures add show them (add to model)
		List <Flight> flights = flightService.getFlights();
		
		theModel.addAttribute("flights", flights);
		
		 return "flight-panel";
	}
	
	
// ========= all DEPARTURE mapping in admin panel =========
	
		@GetMapping("/departureplacepanel")
		public String showDeparturePlacePanel(Model theModel) {
			
			//get all departures places as list
			List <Departure> departures = flightService.getDeparturePlaces();
			
			//pass this departures places to the model (jsp)
			theModel.addAttribute("departures", departures);
			
			return "departureplace-panel";
		}
		
		@GetMapping("/showFormForAddDeparture")
		public String showFormForAddDeparture(Model model) {
			
			//create model attribute to bind form data
			Departure theDeparture = new Departure();
			
			model.addAttribute("departure", theDeparture);
			
			return "departure-form";
		}
		
		@PostMapping("/saveDeparture")
		public String saveDeparture(@Valid @ModelAttribute("departure") Departure theDeparture, BindingResult bindingResult )
		{
			//check if all fields are correctly defined
			if(bindingResult.hasErrors()) return "departure-form";
			else
			{
				//save correctly defined new departure
				flightService.saveDeparture(theDeparture);
			
				return "redirect:/adminpanel/departureplacepanel";
			}
		}
		
		@GetMapping("/departureDelete")
		public String departureDelete(@RequestParam("departureId") int id, Model theModel)
		{
			// return true or false if delete departure is possible (actually should be boolean)
			String answear = flightService.deleteDeparture(id);
			
			//if answear == true, its impossible, show information(add to model)
			if(answear == "true") 
			{
				theModel.addAttribute("answear", "Incorrect operation, one of flights use this place as departure place");
			}
			
			//load again all departures add show them (add to model)
			List <Departure> departures = flightService.getDeparturePlaces();
			
			theModel.addAttribute("departures", departures);
			
			 return "departureplace-panel";
		}	
	
	//Arrival
	
	@GetMapping("/arrivalplacepanel")
	public String showArrivalPlacePanel(Model theModel) {
		
		List <Arrival> arrivals = flightService.getArrivalPlaces();
		
		theModel.addAttribute("arrivals", arrivals);
		
		return "arrivalplace-panel";
	}
	
	@GetMapping("/showFormForAddArrival")
	public String showFormForAddArrival(Model model) {	
		
		//create model attribute to bind form data
		Arrival theArrival = new Arrival();
		
		model.addAttribute("arrival", theArrival);
		
		return "arrival-form";
	}
	
	@PostMapping("/saveArrival")
	public String saveArrival(@Valid @ModelAttribute("arrival") Arrival theArrival, BindingResult bindingResult )
	{
		if(bindingResult.hasErrors()) return "arrival-form";
		else
		{
			flightService.saveArrival(theArrival);
		
			return "redirect:/adminpanel/arrivalplacepanel";
		}
	}
	
	@GetMapping("/arrivalDelete")
	public String arrivalDelete(@RequestParam("arrivalId") int id, Model theModel)
	{
		
		String answear = flightService.deleteArrival(id);
		
		if(answear == "true") 
		{
			theModel.addAttribute("answear", "Incorrect operation, one of flights use this place as arrival place");
		}
		
		List <Arrival> arrivals = flightService.getArrivalPlaces();
		
		theModel.addAttribute("arrivals", arrivals);
		
		 return "arrivalplace-panel";
	}
	
	
	
}
