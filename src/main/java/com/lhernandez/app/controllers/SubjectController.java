package com.lhernandez.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lhernandez.app.handlers.SubjectHandler;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    
    private final SubjectHandler handler;

    public SubjectController(SubjectHandler handler){
        this.handler=handler;
    }

    
}
