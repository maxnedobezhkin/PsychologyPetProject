package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

//	OFFSET LIMIT!!!

@Service
public class PsychologistService {
	
	private final PsychologistRepository psychologistRepository;
	
	@Autowired
	public PsychologistService(PsychologistRepository psychologistRepository) {
		this.psychologistRepository = psychologistRepository;
	}
	
	
	public List<Psychologist> getPsychologist(int limit, int offset) {
		Pageable pageable = PageRequest.of(offset, limit);
		return psychologistRepository.findAll(pageable).getContent();
	}
	
	public void addPsychologist(Psychologist psychologist) {
		if (psychologistRepository.findById(psychologist.getId()).isPresent()) {
			throw new IllegalStateException("this id is taken");
		}
		psychologistRepository.save(psychologist);
	}

//	public void addContacts(Contacts contacts) {
//		// TODO Auto-generated method stub
//		psychologistRepository.save(contacts);
//	}
}
