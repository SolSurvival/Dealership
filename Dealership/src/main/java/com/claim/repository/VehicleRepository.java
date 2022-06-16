package com.claim.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.claim.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	
	
	@Query(value="SELECT * FROM vehicle V WHERE V.make = ?1", nativeQuery = true)
	List<Vehicle> findVehicleByMake(String make);

}
