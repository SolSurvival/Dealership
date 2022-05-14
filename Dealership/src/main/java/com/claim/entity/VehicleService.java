package com.claim.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;

	private List<Vehicle> inventory = new ArrayList<Vehicle>();

	public void saveVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
		//inventory.add(vehicle);
	}

	public Vehicle getVehicle(int id) {
		return getVehicleFromFakeList(id);
		//return vehicleRepository.getById(id);
	}
	
	public void removeVehicleFromInventory(Vehicle vehicle) {
		vehicle.setIsSold(true);
		vehicle.setDaysOnLot(0);
		inventory.remove(vehicle);
	}

	public List<Vehicle> getAll() {
		vehicleRepository.findById(1);
		return vehicleRepository.findAll();
		//return inventory;
	}

	public List<Vehicle> getAllVehiclesByMake(String make) {
		return vehicleRepository.findVehicleByMake(make.toLowerCase());
	}

	public List<Vehicle> getVehicles() {
		if (inventory.size() == 0) {
			inventory = Vehicle.setInitialInventory();
		}
		return vehicleRepository.findAll();
		//return inventory;
	}

	public Vehicle getVehicleFromFakeList(int id) {
		for (Vehicle vehicle : inventory) {
			if (id == vehicle.getId()) {
				return vehicle;
			}
		}

		return null;
	}
	
	public List<Vehicle> getUserVehicles(Person person) {
		return person.getVehicles();
	}
}
