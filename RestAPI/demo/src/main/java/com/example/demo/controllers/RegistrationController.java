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
		// Место для проверки логина
		
		if (registrationService.checkTakenLogin(login)) {
			throw new IllegalArgumentException("This login is taken");
		}
		Psychologist psychologist = new Psychologist();
		PsychologistRegistrationData psychologistRegistrationData = new PsychologistRegistrationData();
		psychologistRegistrationData.setLogin(login);
		psychologistRegistrationData.setPassword(password);
		psychologist.setId(registrationService.takeLastPsychologistId() + 1);
		psychologist.setName(name);
		psychologist.setLastName(lastname);
		/*
		 * Место для установки email или телефона
		 */
		psychologistRegistrationData.setPsychologist(psychologist);
		psychologistRegistrationData.setId(psychologist.getId());
		psychologistService.addPsychologist(psychologist);
		registrationService.addPsychologistRegistrationData(psychologistRegistrationData);
	}
	
	@PostMapping("/patient")
	private void registrationPatient(@RequestParam(name = "name") String name,
									 @RequestParam(name = "lastname") String lastname,
									 @RequestParam(name = "login") String login,
									 @RequestParam(name = "password") String password) {
		// Место для проверки логина
		
		if (registrationService.checkTakenLogin(login)) {
			throw new IllegalArgumentException("This login is taken");
		}
		Patient patient = new Patient();
		PatientRegistrationData patientRegistrationData = new PatientRegistrationData();
		patientRegistrationData.setLogin(login);
		patientRegistrationData.setPassword(password);
		patient.setId(registrationService.takeLastPsychologistId() + 1);
		patient.setName(name);
		patient.setLastname(lastname);
		/*
		 * Место для установки email или телефона
		 */
		patientRegistrationData.setPatient(patient);
		patientRegistrationData.setId(patient.getId());
		registrationService.addPatient(patient);
		registrationService.addPatientRegistrationData(patientRegistrationData);
	}
	
}
