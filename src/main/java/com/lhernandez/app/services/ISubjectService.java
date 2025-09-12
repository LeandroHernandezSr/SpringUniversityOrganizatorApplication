package com.lhernandez.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.lhernandez.app.models.subjects.Subject;

public interface ISubjectService {
	Subject create(Subject subject);
	Subject update(Subject subject);
	Optional<Subject>findSubjectById(String id);
	void deleteSubject(Subject subject);
	Page<Subject>getAllSubjects(PageRequest pageRequest);
	List<Subject>getAllSubjectsList();
}
