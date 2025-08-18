package com.lhernandez.app.handlers;

import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
	
	public ResponseEntity<StudentDto>createStudent(StudentDto studentDto) {
		var response=service.createStudent(mapper.DtoToModel(studentDto));
		return ResponseEntity.status(200).body(mapper.ModeltoDto(response));
	}
	
	public ResponseEntity<Optional<StudentDto>>deleteStudent(StudentDto studentDto){
		var response=service.deleteStudent(mapper.DtoToModel(studentDto));
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(response.map(mapper::ModeltoDto));
	}
	
	public ResponseEntity<Optional<StudentDto>> getStudentById(String id){
		return service.getStudentById(id)
				.map(s->{
					return Optional.of(mapper.ModeltoDto(s));
				})
		        .map(ResponseEntity::ok)
		        .orElseGet(() -> ResponseEntity.notFound().build());
	}
}
