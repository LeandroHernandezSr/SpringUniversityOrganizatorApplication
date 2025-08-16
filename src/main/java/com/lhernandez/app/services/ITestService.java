package com.lhernandez.app.services;

import java.util.Optional;

import com.lhernandez.app.models.test.Test;

public interface ITestService {
	Test create(Test test);
	void delete(Test test);
	Test update(Test test);
	Optional<Test>getById(String id);
}
