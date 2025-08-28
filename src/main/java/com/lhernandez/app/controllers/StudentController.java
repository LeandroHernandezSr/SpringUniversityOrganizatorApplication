package com.lhernandez.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhernandez.app.dto.StudentDto;
import com.lhernandez.app.handlers.StudentHandler;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	private final StudentHandler handler;
	
	public StudentController(StudentHandler handler) {
		this.handler=handler;
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute StudentDto student){
		this.handler.createStudent(student);
		return "form";
	}
	
}
