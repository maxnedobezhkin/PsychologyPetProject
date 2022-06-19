package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Psychologist;

@Repository
public interface PsychologistRepository 
		extends PagingAndSortingRepository<Psychologist, Integer> {
	List<Psychologist> findByName(String name);
	List<Psychologist> findByLastName(String lastName);
	List<Psychologist> findByRegion(String region);
	
//	void save(Contacts contacts);
//

}
