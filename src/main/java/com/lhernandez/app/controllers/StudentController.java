package com.lhernandez.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String create(@ModelAttribute("student") StudentDto student){
	    this.handler.createStudent(student);
	    return "redirect:/student/form";
	}

	
	@GetMapping("/form")
	public String formStudent(Model model) {
		model.addAttribute("title","Create a student");
		model.addAttribute("student",new StudentDto());
		return "formStudent";
	}
	
}
