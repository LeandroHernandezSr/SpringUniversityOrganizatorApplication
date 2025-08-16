package com.lhernandez.app.services;

import java.util.List;
import java.util.Optional;

import com.lhernandez.app.models.subjects.Subject;

public interface ISubjectService {
	Subject create(Subject subject);
	Subject update(Subject subject);
	Optional<Subject>findSubjectById(String id);
	void deleteSubject(Subject subject);
	List<Subject>getAllSubjects();
}
