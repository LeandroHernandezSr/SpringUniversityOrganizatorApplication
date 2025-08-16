package com.lhernandez.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lhernandez.app.mappers.SubjectMapper;
import com.lhernandez.app.models.subjects.Subject;
import com.lhernandez.app.repository.ISubjectEntityRepository;

@Service
public class SubjectServiceImpl implements ISubjectService{
	
	private final ISubjectEntityRepository repository;
	private final SubjectMapper mapper;
	
	public SubjectServiceImpl(ISubjectEntityRepository repository,SubjectMapper mapper) {
		this.repository=repository;
		this.mapper=mapper;
	}

	@Override
	public Subject create(Subject subject) {
		return this.mapper.toModel(this.repository.save(this.mapper.toEntity(subject)));
	}

	@Override
	public Subject update(Subject subject) {
		return this.mapper.toModel(this.repository.save(this.mapper.toEntity(subject)));
	}

	@Override
	public Optional<Subject> findSubjectById(String id) {
		return this.repository.findById(id).map(mapper::toModel);
	}

	@Override
	public void deleteSubject(Subject subject) {
		this.repository.delete(mapper.toEntity(subject));
	}

	@Override
	public List<Subject> getAllSubjects() {
		return this.repository.findAll().stream().map(mapper::toModel).toList();
	}

}
