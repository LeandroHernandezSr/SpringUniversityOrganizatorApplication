package com.lhernandez.app.mappers;


import org.springframework.stereotype.Component;

import com.lhernandez.app.dto.StudentDto;
import com.lhernandez.app.entities.StudentEntity;
import com.lhernandez.app.models.person.Student;

@Component
public class StudentMapper {
	
	private final SubjectMapper subjectMapper;
	private final TestMapper testMapper;
	
	public StudentMapper(SubjectMapper subjectMapper,TestMapper testMapper) {
		this.subjectMapper=subjectMapper;
		this.testMapper=testMapper;
	}
	
	public Student toModel(StudentEntity studentEntity) {
		Student student=new Student();
		student.setId(studentEntity.getId());
		student.setEmail(studentEntity.getEmail());
		student.setName(studentEntity.getName());
		student.setLastName(studentEntity.getLastName());
		student.setPassword(studentEntity.getPassword());
		student.setSubjects(studentEntity.getSubjects().stream().map(subjectMapper::toModel).toList());
		student.setTests(studentEntity.getTests().stream().map(testMapper::toModel).toList());
		return student;
	}
	
	
	public StudentEntity toEntity(Student student) {
		StudentEntity studentEntity=new StudentEntity();
		studentEntity.setId(student.getId());
		studentEntity.setEmail(student.getEmail());
		studentEntity.setName(student.getName());
		studentEntity.setLastName(student.getLastName());
		studentEntity.setPassword(student.getPassword());
		studentEntity.setSubjects(student.getSubjects().stream().map(subjectMapper::toEntity).toList());
		studentEntity.setTests(student.getTests().stream().map(testMapper::toEntity).toList());
		return studentEntity;
	}
	
	public StudentDto ModeltoDto(Student student) {
		StudentDto dto=new StudentDto();
		dto.setEmail(student.getEmail());
		dto.setId(student.getId());
		dto.setLastName(student.getLastName());
		dto.setName(student.getName());
		dto.setPassword(student.getPassword());
		dto.setSubjects(student.getSubjects().stream().map(subjectMapper::modelToDto).toList());
		dto.setTests(student.getTests().stream().map(testMapper::ModelToDto).toList());
		return dto;
	}
	
	public Student DtoToModel(StudentDto dto) {
		Student student=new Student();
		student.setEmail(dto.getEmail());
		student.setId(dto.getId());
		student.setLastName(dto.getLastName());
		student.setName(dto.getLastName());
		student.setPassword(dto.getPassword());
		student.setSubjects(dto.getSubjects().stream().map(subjectMapper::dtoToModel).toList());
		student.setTests(dto.getTests().stream().map(testMapper::dtoToModel).toList());
		return student;
	}
}
