package com.scb.sgml.demospringbootapp.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileUploadController {

	 @PostMapping("/upload")
	    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
	        // You can perform further processing here, such as saving the file to the server
	        // For this example, we'll just print the file name
		 Path filePath = Paths.get("upload-directory", file.getOriginalFilename());
	        System.out.println("Received file: " + file.getOriginalFilename());
	        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	        return "File uploaded successfully";
	    }
}
