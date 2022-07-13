package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.PatientRegistrationRepository;
import com.example.demo.repositories.PsychologistRegistrastionRepository;

@Service
public class UserService {
	
	@Autowired
	private PsychologistRegistrastionRepository psychologistRegistrastionRepository;
	
	@Autowired
	private PatientRegistrationRepository patientRegistrationRepository;
	
	public UserService() {
	}
	
	public Optional<? extends User> getUserByLogin(String login) {
		Optional<? extends User> user = null;
		if (psychologistRegistrastionRepository.findByLogin(login).isPresent()) {
			 user = psychologistRegistrastionRepository.findByLogin(login);
		} else if (patientRegistrationRepository.findByLogin(login).isPresent()) {
			user = patientRegistrationRepository.findByLogin(login);
		}
		return user;
	}

}
