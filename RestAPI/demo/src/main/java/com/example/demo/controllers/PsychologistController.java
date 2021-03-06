package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Psychologist;
import com.example.demo.service.PsychologistService;

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
	
	@GetMapping("/find")
	public Set<Psychologist> findPsychologist(@RequestParam(name = "name", required = false) String name, 
											   @RequestParam(name = "lastName", required = false) String lastName,
											   @RequestParam(name = "region", required = false) String region) {
		List<Psychologist> responseTempList = new ArrayList<>();
		responseTempList.addAll(psychologistService.findPsychologistByName(name));
		responseTempList.addAll(psychologistService.findPsychologistByLastName(lastName));
		responseTempList.addAll(psychologistService.findPsychologistByRegion(region));
		
		Set<Psychologist> responseList = new HashSet<>();
		for (Psychologist psychologist : responseTempList) {
			if ((name == null || (name != null && psychologist.getName().equals(name))) &&
				(lastName == null || (lastName != null && psychologist.getLastName().equals(lastName))) &&
				(region == null || (region != null && psychologist.getRegion().equals(region)))) {
				
				responseList.add(psychologist);
			}
		}
		return responseList;
	}
	
	@PostMapping
	private void savePsychologist(@RequestBody Psychologist psychologist) {
		psychologistService.addPsychologist(psychologist);
	}
	
//	@PostMapping
//	private void registerContacts(@RequestBody Contacts contacts) {
//		System.out.println(contacts);
//		psychologistService.addContacts(contacts);
//	}
	
}
