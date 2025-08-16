package com.lhernandez.app.services;

import java.util.Optional;

import com.lhernandez.app.models.person.Student;

public interface IStudentService {
	Student createStudent(Student student);
	Optional<Student>deleteStudent(Student student);
	Optional<Student>getStudentById(String id);
}
