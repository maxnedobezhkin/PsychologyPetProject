package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//	OFFSET LIMIT!!!

@Service
public class PsychologistService {
	
	private final PsychologistRepository psychologistRepository;
	
	@Autowired
	public PsychologistService(PsychologistRepository psychologistRepository) {
		this.psychologistRepository = psychologistRepository;
	}
	
	public List<Psychologist> getPsychologist() {
		return psychologistRepository.findAll();
	}
}
