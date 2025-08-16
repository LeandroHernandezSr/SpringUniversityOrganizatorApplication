package com.lhernandez.app.entities;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import com.lhernandez.app.models.person.Person;

@Document(collection = "students")
public class StudentEntity extends Person{
	
	@Id
	private String id;
	private List<SubjectEntity>subjects;
	private List<TestEntity>tests;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public List<SubjectEntity> getSubjects() {
		return subjects;
	}
	
	public void setSubjects(List<SubjectEntity> subjects) {
		this.subjects = subjects;
	}
	
	public List<TestEntity> getTests() {
		return tests;
	}
	
	public void setTests(List<TestEntity> tests) {
		this.tests = tests;
	}
	
}
