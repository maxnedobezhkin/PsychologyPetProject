package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Psychologist;

@Repository
public interface PsychologistRepository 
		extends PagingAndSortingRepository<Psychologist, Integer> {

//	void save(Contacts contacts);
//

}
