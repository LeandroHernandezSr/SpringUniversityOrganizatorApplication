package com.lhernandez.app.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lhernandez.app.mappers.StudentMapper;
import com.lhernandez.app.models.person.Student;
import com.lhernandez.app.repository.IStudentEntityRepository;

@Service
public class StudentServiceImpl implements IStudentService{
	
	private final IStudentEntityRepository repository;
	private final StudentMapper mapper;
	 
	public StudentServiceImpl(IStudentEntityRepository repository,StudentMapper mapper) {
		this.repository=repository;
		this.mapper=mapper;
	}

	@Override
	public Student createStudent(Student student) {
		return mapper.toModel(this.repository.save(mapper.toEntity(student)));
	}

	@Override
	public Optional<Student> deleteStudent(Student student) {
		return Optional.of(this.repository.save(mapper.toEntity(student))).map(mapper::toModel);
	}

	@Override
	public Optional<Student> getStudentById(String id) {
		return this.repository.findById(id).map(mapper::toModel);
	}

}
