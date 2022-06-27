package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Patient;
import com.example.demo.entities.PatientRegistrationData;

@Repository
public interface PatientRegistrationRepository 
	extends JpaRepository<PatientRegistrationData, Integer> {
	
	Object findByLogin(String login);
}
