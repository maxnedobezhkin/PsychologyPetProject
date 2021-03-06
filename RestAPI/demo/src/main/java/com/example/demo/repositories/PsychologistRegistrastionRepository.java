package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Psychologist;
import com.example.demo.entities.PsychologistRegistrationData;

public interface PsychologistRegistrastionRepository
	extends JpaRepository<PsychologistRegistrationData, Integer>{

	Optional<PsychologistRegistrationData> findByLogin(String login);
}
