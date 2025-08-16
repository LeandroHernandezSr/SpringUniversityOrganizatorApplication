package com.lhernandez.app.models.person;

import java.util.List;

import com.lhernandez.app.models.subjects.Subject;
import com.lhernandez.app.models.test.Test;

public class Student extends Person{
	
	private List<Subject>subjects;
	private List<Test>tests;
	
	public List<Subject> getSubjects() {
		return subjects;
	}
	
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public List<Test> getTests() {
		return tests;
	}
	
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}
	
}
