package com.healthconnection.application.usecase;

public interface RuleValidator<T> {

	void validate(T data);
}
