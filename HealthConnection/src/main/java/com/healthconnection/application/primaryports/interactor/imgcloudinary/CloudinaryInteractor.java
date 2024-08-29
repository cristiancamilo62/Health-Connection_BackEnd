package com.healthconnection.application.primaryports.interactor.imgcloudinary;

import java.util.Map;
import org.springframework.stereotype.Service;
import com.healthconnection.application.primaryports.interactor.InteractorWithReturn;

@Service
public interface CloudinaryInteractor extends InteractorWithReturn<byte [], Map<String, Object>>{

}
