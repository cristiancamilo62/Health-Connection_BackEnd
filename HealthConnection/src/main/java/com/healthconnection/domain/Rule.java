package com.healthconnection.domain;

import org.springframework.stereotype.Service;

@Service
public interface Rule<T> {
	
	void execute(T data);

}
