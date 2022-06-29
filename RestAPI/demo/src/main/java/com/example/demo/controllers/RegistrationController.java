package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Patient;
import com.example.demo.entities.PatientRegistrationData;
import com.example.demo.entities.Psychologist;
import com.example.demo.entities.PsychologistRegistrationData;
import com.example.demo.service.PsychologistService;
import com.example.demo.service.RegistrationService;

@RestController
@RequestMapping(path = "/registration")
public class RegistrationController {
	
	private RegistrationService registrationService;
	
	@Autowired
	private PsychologistService psychologistService;
	
	@Autowired
	public RegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}
	
	@PostMapping("/psychologist")
	private void registrationPsychologist(@RequestParam(name = "name") String name,
										  @RequestParam(name = "lastname") String lastname,
										  @RequestParam(name = "login") String login,
										  @RequestParam(name = "password") String password) {
		Psychologist psychologist = new Psychologist();
		PsychologistRegistrationData psychologistRegistrationData = new PsychologistRegistrationData();
		
		// Место для проверки логина
		
		if (registrationService.checkTakenPsychologistLogin(login)) {
			throw new IllegalArgumentException("This login is taken");
		}
		psychologistRegistrationData.setLogin(login);
		psychologistRegistrationData.setPassword(password);
		psychologist.setName(name);
		psychologist.setLastName(lastname);
		psychologistRegistrationData.setPsychologist(psychologist);
		psychologistService.addPsychologist(psychologist);
		registrationService.addPsychologistRegistrationData(psychologistRegistrationData);
	}
	
	@PostMapping("/patient")
	private void registrationPatient(@RequestBody PatientRegistrationData patientRegistrationData) {
		registrationService.addPatient(patientRegistrationData);
	}
}
