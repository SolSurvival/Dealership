package com.claim.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.claim.entity.Person;
import com.claim.entity.PersonService;
import com.claim.entity.VehicleService;


@Controller
public class PersonController {

	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	PersonService personService;


	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/signUp")
	public ModelAndView signUp(Model model) {
		return new ModelAndView("sign-up", "person", new Person());
	}
	
	@PostMapping("/signUp")
	public String handleSignUp(@ModelAttribute("person") Person person, Model model) {
		personService.savePerson(person);
		
		return "sign-in";
	}
	
	@GetMapping("/signIn")
	public ModelAndView signIn(Model model) {
		return new ModelAndView("sign-in", "person", new Person());
	}
	
	@PostMapping("/signIn")
	public String handleSignIn(@ModelAttribute("person") Person person, Model model) {
		Person signedUpPerson = personService.verifyPersonLogin(person.getFullName(), person.getPassword());
		if(signedUpPerson != null) {
			model.addAttribute("person", signedUpPerson);
			model.addAttribute("vehicleInventory", vehicleService.getVehicles());
			return "list";
		}
		
		model.addAttribute("errorMessage", "ERROR");
		return "sign-in";
	}
	
	@GetMapping("/account/{userId}")
	public String account(@PathVariable("userId") Integer personId, Model model) {
		Person signedInPerson = personService.getPerson(personId);
		System.out.println(signedInPerson.getVehicles().toString());
		model.addAttribute("person", signedInPerson);
		model.addAttribute("vehicleInventory", vehicleService.getUserVehicles(signedInPerson));
		return "list";
	}

	
}
