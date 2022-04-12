package com.example.demo;


import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/img")
public class ImageController {
	
	@Autowired
	private ImageRepository imageRepository;
	
	@GetMapping("image/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws SQLException {
		
		Optional<Image> image = imageRepository.findById(id);
		byte [] imageBytes = null;
		if (image.isPresent()) {
			imageBytes = image.get().getImageContent().getBytes(1, (int) image.get().getImageContent().length());
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}
	
}
