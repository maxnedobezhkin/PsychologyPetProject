package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Psychologist;
import com.example.demo.entities.PsychologistRegistrationData;
import com.example.demo.repositories.PsychologistRegistrastionRepository;

@Service
public class RegistrationService {
	
	private PsychologistRegistrastionRepository psychologistRegistrationRepository;
	
	@Autowired
	public RegistrationService(PsychologistRegistrastionRepository psychologistRegistrationRepository) {
		this.psychologistRegistrationRepository = psychologistRegistrationRepository;
	}
	
	
	public void addPsychologist(PsychologistRegistrationData psychologistRegistrationData) {
		if (psychologistRegistrationRepository.findByLogin(psychologistRegistrationData.getLogin()) != null) {
			throw new IllegalStateException("this login is taken");
		}
		psychologistRegistrationRepository.save(psychologistRegistrationData);
	}
}
