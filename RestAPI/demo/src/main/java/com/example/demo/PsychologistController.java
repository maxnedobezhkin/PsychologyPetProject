package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Psychologist> getPsychologist(@RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset) {
		int limitValue = 25;
		int offsetValue = 0;
		
		if (limit != null) {
			limitValue = limit.intValue();
		}
		
		if (offset != null) {
			offsetValue = offset.intValue();
		}
		return psychologistService.getPsychologist(limitValue, offsetValue);
	}
	

	
	@PostMapping
	private void registerPsychologist(@RequestBody Psychologist psychologist) {
		psychologistService.addPsychologist(psychologist);
	}
	
//	@PostMapping
//	private void registerContacts(@RequestBody Contacts contacts) {
//		System.out.println(contacts);
//		psychologistService.addContacts(contacts);
//	}
	
}
