package com.lhernandez.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhernandez.app.dto.SubjectDto;
import com.lhernandez.app.handlers.SubjectHandler;
import com.lhernandez.app.models.Days;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    
    private final SubjectHandler handler;

    public SubjectController(SubjectHandler handler){
        this.handler=handler;
    }


    @GetMapping("/form")
    public String formSubject(Model model){
        model.addAttribute("title", "Create a subject");
        model.addAttribute("subject", new SubjectDto());
        model.addAttribute("daysEnum",Days.values());
        return "formSubject";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("subject") SubjectDto subject) {
        this.handler.create(subject);
        return "redirect:/subject/form";
    }

    @GetMapping("/list")
    public String getAllSubjects(Model model){
        model.addAttribute("title", "Subjects");
        model.addAttribute("subjects", this.handler.getAllSubjects());
        return "listSubjects";
    }
}
