package com.healthconnection.application.usecase.imgcloudinary;

import java.util.Map;
import org.springframework.stereotype.Service;
import com.healthconnection.application.usecase.UseCaseWithReturn;

@Service
public interface CloudinaryUseCase extends UseCaseWithReturn<byte [], Map<String, Object>>{

}
