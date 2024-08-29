package com.healthconnection.application.primaryports.interactor.imgcloudinary.impl;

import java.util.Map;
import org.springframework.stereotype.Service;
import com.healthconnection.application.primaryports.interactor.imgcloudinary.CloudinaryInteractor;
import com.healthconnection.application.usecase.imgcloudinary.CloudinaryUseCase;
import com.healthconnection.crosscutting.helper.ObjectHelper;

@Service
public class CloudinaryInteractorImpl implements CloudinaryInteractor {

    private final CloudinaryUseCase cloudinaryUseCase;

    public CloudinaryInteractorImpl(CloudinaryUseCase cloudinaryUseCase) {
        this.cloudinaryUseCase = cloudinaryUseCase;
    }

    @Override
    public Map<String, Object> execute(byte[] imageBytes) {
    	
        if (ObjectHelper.isNull(imageBytes) || ObjectHelper.isEmpty(imageBytes)) {
            throw new IllegalArgumentException("MultipartFile data is null or empty");
        }
        return cloudinaryUseCase.execute(imageBytes);
    }
}
