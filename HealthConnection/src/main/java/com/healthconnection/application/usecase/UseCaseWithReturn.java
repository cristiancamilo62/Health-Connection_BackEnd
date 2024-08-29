package com.healthconnection.application.usecase;


public interface UseCaseWithReturn<D,R> {
	
	R execute(D data);

}
