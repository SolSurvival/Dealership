package com.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.claim.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	@Query(value="select * from person where name = ?1 && password=?2", nativeQuery=true)
	Person login(String name, String password);

}


