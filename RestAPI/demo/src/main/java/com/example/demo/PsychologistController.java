package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class PsychologistController {
	
	private final PsychologistService psychologistService;
	
	@Autowired
	public PsychologistController(PsychologistService psychologistService) {
		this.psychologistService = psychologistService;
	}
	
	@GetMapping
	public List<Psychologist> getPsychologist() {
		return psychologistService.getPsychologist();
	}
}
