package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.PsychologistRegistrationData;

public interface PsychologistRegistrastionRepository
	extends JpaRepository<PsychologistRegistrationData, Integer>{

	Object findByLogin(String login);

}
