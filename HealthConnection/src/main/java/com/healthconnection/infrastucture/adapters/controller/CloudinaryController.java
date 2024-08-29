package com.healthconnection.infrastucture.adapters.controller;

import java.io.IOException;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.healthconnection.application.primaryports.interactor.imgcloudinary.CloudinaryInteractor;

@RestController
@RequestMapping("/api/vi/cloudinary")
public class CloudinaryController {
	
	private final CloudinaryInteractor cloudinaryInteractor;

	public CloudinaryController(CloudinaryInteractor cloudinaryInteractor) {
		super();
		this.cloudinaryInteractor = cloudinaryInteractor;
	}
	
	 @PostMapping("/upload")
	    public Map<String, Object> uploadImage(@RequestParam("image") MultipartFile image) throws IOException{
		 
		 return cloudinaryInteractor.execute(image.getBytes());
		 
	 }
}
