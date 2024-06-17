package com.healthconnection.application.primaryports.mapper;

public interface MapperDTO<T,D> {
	
	D toDomain(T dto);
	
	T toDTO(D domain);

}
