package com.lhernandez.app.handlers;

import java.util.Optional;


import org.springframework.stereotype.Component;

import com.lhernandez.app.dto.StudentDto;
import com.lhernandez.app.mappers.StudentMapper;
import com.lhernandez.app.services.IStudentService;

@Component
public class StudentHandler {
	
	private final IStudentService service;
	private final StudentMapper mapper;
	
	public StudentHandler(IStudentService service,StudentMapper mapper) {
		this.service=service;
		this.mapper=mapper;
	}
	
	public Optional<StudentDto>createStudent(StudentDto studentDto) {
		return Optional.of(studentDto)
				.map(mapper::DtoToModel)
				.map(service::createStudent)
				.map(mapper::ModeltoDto);
	}
	
	public Optional<StudentDto>deleteStudent(StudentDto studentDto){
		return Optional.of(studentDto)
				.map(mapper::DtoToModel)
				.map(service::deleteStudent)
				.get()
				.map(mapper::ModeltoDto);
				
	}
	
	public Optional<StudentDto> getStudentById(String id){
		return this.service.getStudentById(id)
				.map(mapper::ModeltoDto);
	}
}
