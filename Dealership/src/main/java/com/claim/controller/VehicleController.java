package com.claim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.claim.entity.Person;
import com.claim.entity.PersonService;
import com.claim.entity.Vehicle;
import com.claim.entity.VehicleService;


@Controller
public class VehicleController {

	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	PersonService personService;


	@GetMapping("/addVehicle")
	public ModelAndView addVehiclePage(Model model) {
		return new ModelAndView("add-vehicle", "vehicle", new Vehicle());
	}
	
	@PostMapping("/addVehicle")
	public String submitVehicle(@ModelAttribute("vehicle") Vehicle vehicle, Model model) {
		vehicleService.saveVehicle(vehicle);
		List<Vehicle> inventory = vehicleService.getAllVehiclesByMake("Ford");
		model.addAttribute("vehicleInventory", inventory);
		return "list";
	}

	@GetMapping("/inventoryList")
	public String inventoryList(Model model) {
		List<Vehicle> inventory = vehicleService.getVehicles();
		model.addAttribute("vehicleInventory", inventory);
		return "list";
	}
	
	@GetMapping("/inventoryListLoggedIn/{userId}")
	public String loggedInInventoryList(@PathVariable("userId") Integer personId, Model model) {
		Person signedInPerson = personService.getPerson(personId);
		model.addAttribute("person", signedInPerson);
		model.addAttribute("vehicleInventory", vehicleService.getVehicles());
		return "list";
	}
	
	@GetMapping("/profile/{userId}")
	public String vehicleProfile(@PathVariable("userId") Integer personId, @RequestParam(value = "vehicleId", required = false) Integer vehicleId, Model model) {
		Vehicle vehicle = vehicleService.getVehicle(vehicleId);
		model.addAttribute("vehicle", vehicle);
		
		Person person;
		if(personId != null) {
			person = personService.getPerson(personId);
			model.addAttribute("person", person);
		}
		if(vehicle == null) {
			return "list";
		}
		
		return "profile";
	}
	
	@GetMapping("/confirmation")
	public String buyVehicle(
			@RequestParam(value = "userId", required = false) Integer personId,
			@RequestParam(value = "vehicleId", required = false) Integer vehicleId,
			Model model
			) {
		Vehicle vehicle = vehicleService.getVehicle(vehicleId);
		Person person = personService.getPerson(personId);
		
		personService.buyVehicle(person, vehicle);
		vehicleService.removeVehicleFromInventory(vehicle);
		model.addAttribute("person", person);
		
		return "confirmation";
	}
	
}
