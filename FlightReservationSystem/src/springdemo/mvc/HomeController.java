package springdemo.mvc;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springdemo.entity.Arrival;
import springdemo.entity.Client;
import springdemo.entity.Departure;
import springdemo.entity.Flight;
import springdemo.service.FlightService;

@RequestMapping("/")
@Controller
public class HomeController {
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping("/list")
	public String showPage(Model theModel) {
		
		// get departures and arrivals from service
		List <Departure> departures = flightService.getDeparturePlaces();
		List <Arrival> theArrivals = flightService.getArrivalPlaces();
		
		// add departures and arrivals to the model
		theModel.addAttribute("departures", departures);
		theModel.addAttribute("arrivals", theArrivals);
		
		return "main-web"; 
	}
	
	@GetMapping("/processForm")
	public String processForm(@RequestParam Map <String, String> requestParams, 
							  @RequestParam("numberOfPassangers") int numberOfPassangers, Model theModel 
							  ) throws ParseException {
		
		// get list of available flights matching the search
		List <Flight> allFlights = flightService.getFlight(requestParams.get("destinationPlace"), requestParams.get("arrivalPlace"),
													requestParams.get("date"), requestParams.get("flightClass"), numberOfPassangers);
		
		if(allFlights.size() == 0)	return "have-no-flights";
		else
		{
			int fullPrice = 0;
			
			// set All required params
			addParamsToTheModel(requestParams,theModel, this.flightService, allFlights, numberOfPassangers,fullPrice);
			theModel.addAttribute("fullprice", numberOfPassangers*fullPrice);
			
			return "step-second";
		}
	}	
	
	// Mapping for return flight
	@GetMapping("/processForm2")
	public String processForm2( @RequestParam Map <String, String> requestParams, Model theModel) throws ParseException {
		
		int numberOfPassangers = Integer.parseInt(requestParams.get("numberOfPassangers"));
	
		// get list of available flights matching the search
		List <Flight> allFlights = flightService.getFlight(requestParams.get("destinationPlace"), requestParams.get("arrivalPlace"),
				requestParams.get("date"), requestParams.get("flightClass"), numberOfPassangers);
		
		if(allFlights.size() == 0)	return "have-no-flights";
		else
		{
			int fullPrice = 0;
		
			// set All required params
			addParamsToTheModel(requestParams,theModel, this.flightService, allFlights, numberOfPassangers,fullPrice);
			theModel.addAttribute("fp", requestParams.get("fp"));
			theModel.addAttribute("firstflightnumber", requestParams.get("firstflightnumber"));
			theModel.addAttribute("fullprice", numberOfPassangers*fullPrice + Integer.parseInt(requestParams.get("fp")));
			
			return "step-second-two";
		}
	}
	
	@GetMapping("/client-details")
	public String clientData(@RequestParam Map <String, String> requestParams, Model theModel) {
		
		// pass whole params
		theModel.addAttribute("numberOfPassangers", requestParams.get("numberOfPassangers"));
		theModel.addAttribute("flightClass", requestParams.get("flightClass"));
		theModel.addAttribute("firstflightnumber", requestParams.get("firstflightnumber"));
		theModel.addAttribute("secondflightnumber", requestParams.get("secondflightnumber"));
		
		Client theClient = new Client();
		theModel.addAttribute(theClient);
		
		return "client-form";
	}
	
	@PostMapping("/save")
	public String save(@RequestParam Map <String, String> requestParams, Model theModel )
	{
		// create client base on entered info
		Client theClient = new Client();
		theClient.setFirstName(requestParams.get("firstname"));
		theClient.setLastName(requestParams.get("lastname"));
		theClient.setSex(requestParams.get("sex"));
		theClient.setBirthday(requestParams.get("birthday"));
		theClient.setBirthplace(requestParams.get("birthplace"));
		theClient.setTelephoneNumber(Integer.parseInt(requestParams.get("telephonenumber")));
		theClient.setEmail(requestParams.get("email"));
			
		// save client in database
		flightService.saveClient(theClient);
		
		//save first flight reservation in database 
		flightService.saveReservation( requestParams.get("firstflightnumber"), 
									   requestParams.get("flightClass"),
									   requestParams.get("numberOfPassangers"),
									   theClient);
			
		// if user add return flight, add reservation return flight on database
		if(!(requestParams.get("secondflightnumber").toString().equals("null")))
		{
			flightService.saveReservation( requestParams.get("secondflightnumber"), 
					   					   requestParams.get("flightClass"),
					   					   requestParams.get("numberOfPassangers"),
					   					   theClient);
		}
			
		return "ending";
	}
	
	public static void addParamsToTheModel(Map <String, String> requestParams,Model theModel,
										FlightService flightService, List <Flight> allFlights, int numberOfPassangers, int fullPrice) {

		// get the earlier flight, set time without seconds, add flight to the model
		Flight firstFlight = allFlights.get(0);
		firstFlight.setDepartureTime(firstFlight.getDepartureTime().substring(0,5));
		firstFlight.setArrivalTime(firstFlight.getArrivalTime().substring(0, 5));
		theModel.addAttribute("flight", firstFlight);
		
		// set some potential prices for flight class and add it to the model
		if(requestParams.get("flightClass").equals("Business")) fullPrice = firstFlight.getFlightPrice()*3;
		else if (requestParams.get("flightClass").equals("First")) fullPrice = firstFlight.getFlightPrice()*5;
		else fullPrice = firstFlight.getFlightPrice();
		
		theModel.addAttribute("price", fullPrice);
		allFlights.remove(0);
		
		// add info about chosen reservation to the model
		theModel.addAttribute("flightClass", requestParams.get("flightClass") );
		theModel.addAttribute("numberOfPassangers", numberOfPassangers);
		theModel.addAttribute("length", allFlights.size());
		
		// add rest flights to the model if exists 
		if(allFlights.size() != 0) 
		{
			List <Flight> restFlights = new ArrayList();
			restFlights.addAll(allFlights);
			theModel.addAttribute("restFlights", restFlights);
		}
	}

}
