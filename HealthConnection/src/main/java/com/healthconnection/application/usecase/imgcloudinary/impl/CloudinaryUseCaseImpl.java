package com.healthconnection.application.usecase.imgcloudinary.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.healthconnection.application.usecase.imgcloudinary.CloudinaryUseCase;

@Service
public class CloudinaryUseCaseImpl implements CloudinaryUseCase{

	private final Cloudinary cloudinary;
	
	public CloudinaryUseCaseImpl(Cloudinary cloudinary) {
		this.cloudinary = cloudinary;	
	}

	@SuppressWarnings("unchecked")
	@Override
    public Map<String, Object> execute(byte[] imageBytes) {
        try {
            return cloudinary.uploader().upload(imageBytes, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

}
