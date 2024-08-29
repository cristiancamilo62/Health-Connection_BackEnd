package com.healthconnection.application.usecase;

public interface UseCaseWithoutReturn<D> {
	
	void execute(D data);

}
