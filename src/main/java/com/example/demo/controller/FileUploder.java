package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Templet.UploadFile;

@RestController
public class FileUploder {

	@Autowired
	private UploadFile uploadStaticFile;

	
	@PostMapping("/uploadfile")
	public ResponseEntity<String> FetchFile(@RequestParam("file") MultipartFile file) {

		try {

			if (file.isEmpty()) {

				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

			}

			if (file.getContentType().equals("image/jpeg")) {

				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Someting want wrong");

			}

			boolean updateFile = uploadStaticFile.UpdateFile(file);

			if (updateFile) {
				//return ResponseEntity.ok("Upload Succesfully");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/img/").path(file.getOriginalFilename()).toString());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not uploded try againg");

	}
}
