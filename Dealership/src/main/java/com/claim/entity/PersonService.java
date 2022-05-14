package com.claim.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	List<Person> peopleList = new ArrayList<Person>();

	int idCounter = 1;
	public Person savePerson(Person person) {
		try {
			person.setId(idCounter);
			idCounter++;
			peopleList.add(person);
			personRepository.save(person);
			return person;
		} catch (Exception e) {
			return null;
		}

	}

	public Person verifyPersonLogin(String fullName, String password) {
		for (Person person : peopleList) {
			if (person.getFullName().equals(fullName) && person.getPassword().equals(password)) {
				return person;
			}
		}
		return null;
	}
	

	public Person getPerson(int id) {
		for (Person person : peopleList) {
			if (person.getId() == id) {
				return person;
			}
		}

		return null;
	}
	
	public Person buyVehicle(Person person, Vehicle vehicle) {
		person.vehicles.add(vehicle);
		personRepository.save(person);

		return null;
	}
}
