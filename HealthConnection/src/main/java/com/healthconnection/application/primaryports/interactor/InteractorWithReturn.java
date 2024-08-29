package com.healthconnection.application.primaryports.interactor;

public interface InteractorWithReturn<D,R> {
	
	R execute(D data);

}
