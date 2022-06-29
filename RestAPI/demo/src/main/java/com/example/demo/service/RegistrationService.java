package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Patient;
import com.example.demo.entities.PatientRegistrationData;
import com.example.demo.entities.Psychologist;
import com.example.demo.entities.PsychologistRegistrationData;
import com.example.demo.repositories.PatientRegistrationRepository;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.repositories.PsychologistRegistrastionRepository;

@Service
public class RegistrationService {
	
	private PsychologistRegistrastionRepository psychologistRegistrationRepository;
	
	@Autowired
	private PatientRegistrationRepository patientRegistrationRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	public RegistrationService(PsychologistRegistrastionRepository psychologistRegistrationRepository) {
		this.psychologistRegistrationRepository = psychologistRegistrationRepository;
	}
	
	
	public void addPsychologistRegistrationData(PsychologistRegistrationData psychologistRegistrationData) {
		if (psychologistRegistrationRepository.findByLogin(psychologistRegistrationData.getLogin()) != null) {
			throw new IllegalStateException("this login is taken");
		}
		psychologistRegistrationRepository.save(psychologistRegistrationData);
	}
	
	public void addPatient(PatientRegistrationData patientRegistrationData) {
		Patient patient = new Patient();
		patient.setName(patientRegistrationData.getName());
		patient.setLastname(patientRegistrationData.getLastname());
		
		patientRegistrationRepository.save(patientRegistrationData);
	}
	
	public boolean checkTakenPsychologistLogin(String login) {
		if (psychologistRegistrationRepository.findByLogin(login).isPresent()) {
			return true;
		} else {
			return false;
		}
	}
}
