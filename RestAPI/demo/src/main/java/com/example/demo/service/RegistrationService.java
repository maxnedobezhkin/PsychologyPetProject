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
import com.example.demo.repositories.PsychologistRepository;

@Service
public class RegistrationService {
	
	private PsychologistRegistrastionRepository psychologistRegistrationRepository;
	
	@Autowired
	private PatientRegistrationRepository patientRegistrationRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PsychologistRepository psychologistRepository;
	
	@Autowired
	public RegistrationService(PsychologistRegistrastionRepository psychologistRegistrationRepository) {
		this.psychologistRegistrationRepository = psychologistRegistrationRepository;
	}
	
	
	public void addPsychologistRegistrationData(PsychologistRegistrationData psychologistRegistrationData) {
		psychologistRegistrationRepository.save(psychologistRegistrationData);
	}
	
	public void addPatient(Patient patient) {
		patientRepository.save(patient);
	}
	
	public void addPatientRegistrationData(PatientRegistrationData patientRegistrationData) {
		patientRegistrationRepository.save(patientRegistrationData);
	}
	
	public boolean checkTakenLogin(String login) {
		if (psychologistRegistrationRepository.findByLogin(login).isPresent() ||
				 patientRegistrationRepository.findByLogin(login).isPresent()) {
			return true;
		} else {
			return false;
		}
	}
	
	public int takeLastPsychologistId() {
		if (psychologistRepository.findTopByOrderByIdDesc() == null) {
			return 0;
		}
		return psychologistRepository.findTopByOrderByIdDesc().getId();
	}
	
	public int takeLastPatientId() {
		if (patientRepository.findTopByOrderByIdDesc() == null) {
			return 0;
		}
		return patientRepository.findTopByOrderByIdDesc().getId();
	}
	
	public int defineLogin(String login) {
		String emailPattern = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		String phonePattern = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
		if (login.matches(emailPattern)) {
			return 1;
		} else if (login.matches(phonePattern)) {
			return 2;
		} else {
			return 0;
		}
	}
	
}
