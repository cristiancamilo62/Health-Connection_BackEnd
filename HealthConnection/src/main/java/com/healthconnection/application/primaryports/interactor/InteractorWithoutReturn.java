package com.healthconnection.application.primaryports.interactor;

public interface InteractorWithoutReturn<D> {
	
	void execute(D data);

}
