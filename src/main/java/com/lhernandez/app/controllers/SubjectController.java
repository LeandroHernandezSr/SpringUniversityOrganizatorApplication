package com.lhernandez.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String formSubject(Model model,SubjectDto subjectDto){
        model.addAttribute("title", "Create a subject");
        model.addAttribute("subject", subjectDto);
        model.addAttribute("daysEnum",Days.values());
        return "formSubject";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("subject") SubjectDto subject) {
        this.handler.create(subject);
        return "redirect:/subject/list";
    }

    @GetMapping("/list")
    public String getAllSubjects(Model model){
        model.addAttribute("title", "Subjects");
        model.addAttribute("subjects", this.handler.getAllSubjects());
        return "listSubjects";
    }

    @GetMapping("/delete/{id}")
    public String deleteSubject(@PathVariable String id){
        this.handler.deleteSubject(this.handler.findById(id).get());
        return "redirect:/subject/list";
    }

    @GetMapping("/update/{id}")
    public String updateSubject(@PathVariable String id,Model model){
        model.addAttribute("subject",this.handler.findById(id).get());
        model.addAttribute("daysEnum",Days.values());
        return "formSubject";
    }


}
