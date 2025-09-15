package com.lhernandez.app.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("subjects",subjectHandler.getAllSubjectsList());
        model.addAttribute("test", test);
        model.addAttribute("title", "Create test");
        return "testForm";
    }

    @PostMapping("/create")
    public String createTest(@ModelAttribute("test") TestDto test){
        test.setSubject(this.subjectHandler.findById(test.getSubject().getId()).get());
        this.handler.create(test);
        return "redirect:/test/list";
    }

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "0") int page,Model model){
        model.addAttribute("title", "List of tests");
        model.addAttribute("tests",this.handler.getAllTestPageable(PageRequest.of(page,2)));
        return "listTests";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        TestDto test=this.handler.getById(id).get();
        this.handler.delete(test);
        return "redirect:/test/list";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute("test") TestDto test){
        this.handler.update(test);
        return "redirect:/test/list";
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") String id,Model model){
        model.addAttribute("test", this.handler.getById(id).get());
        model.addAttribute("title", "Update test");
        model.addAttribute("subjects",subjectHandler.getAllSubjectsList());
        return "testForm";
    }


}
