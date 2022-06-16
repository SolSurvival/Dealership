package com.claim.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.claim.entity.Person;
import com.claim.entity.PersonService;
import com.claim.entity.Vehicle;
import com.claim.entity.VehicleService;


//@CrossOrigin
@RestController
public class RestVehicleController {

	@Autowired
	VehicleService vehicleService;
	


	@RequestMapping(value="/get/{vehicleId}", 
			 consumes=MediaType.APPLICATION_JSON_VALUE, 
			 produces=MediaType.APPLICATION_JSON_VALUE,
			 method= RequestMethod.GET
			 )
	public ResponseEntity<Vehicle> getVehicle(@PathVariable("vehicleId") int vehicleId) {
		System.out.println("Hello");

		Vehicle myCar = new Vehicle();
		List<Vehicle> list = Vehicle.setInitialInventory();
		for(Vehicle vehicle : list) {
			if(vehicle.getId() == 1) {
				return new ResponseEntity<>(vehicle, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
}
