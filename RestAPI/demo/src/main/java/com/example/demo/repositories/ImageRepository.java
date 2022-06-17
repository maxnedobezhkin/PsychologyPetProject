package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>{
	Optional<Image> findById(Long id);
}
