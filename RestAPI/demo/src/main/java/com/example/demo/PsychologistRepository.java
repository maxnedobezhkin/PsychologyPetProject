package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PsychologistRepository 
		extends PagingAndSortingRepository<Psychologist, Integer> {

//	void save(Contacts contacts);
//

}
