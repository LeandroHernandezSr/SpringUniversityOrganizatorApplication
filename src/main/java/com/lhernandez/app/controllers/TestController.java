package com.lhernandez.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhernandez.app.dto.TestDto;
import com.lhernandez.app.handlers.SubjectHandler;
import com.lhernandez.app.handlers.TestHandler;

@Controller
@RequestMapping("/test")
public class TestController {
    
    private final TestHandler handler;
    private final SubjectHandler subjectHandler;

    public TestController(TestHandler handler,SubjectHandler subjectHandler){
        this.handler=handler;
        this.subjectHandler=subjectHandler;
    }

    @GetMapping("/form")
    public String testForm(Model model,TestDto test){
        model.addAttribute("subjects",subjectHandler.getAllSubjects());
        model.addAttribute("test", test);
        model.addAttribute("title", "Create test");
        return "testForm";
    }

    @PostMapping("/create")
    public String createTest(@ModelAttribute("test") TestDto test){
        System.out.print("ID de subject: ".concat(test.getSubject().getId()));
        System.out.print("Points: ".concat(String.valueOf(test.getPoints())));
        test.setSubject(this.subjectHandler.findById(test.getSubject().getId()).get());
        this.handler.create(test);
        return "redirect:/test/list";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("title", "List of tests");
        model.addAttribute("tests",this.handler.getAllTest());
        return "listTests";
    }
}
