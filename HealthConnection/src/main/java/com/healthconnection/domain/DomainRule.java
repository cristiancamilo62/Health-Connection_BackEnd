package com.healthconnection.domain;

import org.springframework.stereotype.Service;

@Service
public interface DomainRule<T> {
	
	void execute(T data);

}
