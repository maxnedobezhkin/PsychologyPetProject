package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PsychologistRepository 
		extends JpaRepository<Psychologist, String> {

//	void save(Contacts contacts);
//

}
