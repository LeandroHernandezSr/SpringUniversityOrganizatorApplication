package com.lhernandez.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<StudentDto> create(@RequestBody StudentDto dto){
		return null;
	}
	
}
