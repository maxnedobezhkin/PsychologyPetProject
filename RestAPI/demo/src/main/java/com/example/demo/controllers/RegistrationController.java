package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	private void registrationPsychologist(@RequestBody PsychologistRegistrationData psychologistRegistrationData) {
		Psychologist psychologist;
		if (psychologistService.findPsychologistById(psychologistRegistrationData.getId()).isPresent()) {
			psychologist = psychologistService.findPsychologistById(psychologistRegistrationData.getId()).get();
		} else {
			throw new NullPointerException("no psychologist");
		}
		if (psychologist != null) {
			psychologistRegistrationData.setPsychologist(psychologist);
		}
		registrationService.addPsychologist(psychologistRegistrationData);
	}
	
	@PostMapping("/patient")
	private void registrationPatient(@RequestBody PatientRegistrationData patientRegistrationData) {
		registrationService.addPatient(patientRegistrationData);
	}
}
