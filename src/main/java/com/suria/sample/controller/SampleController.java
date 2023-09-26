package com.suria.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {


    @GetMapping
    public String  getJavaVersion(){
        return Runtime.version().toString();
    }
}
