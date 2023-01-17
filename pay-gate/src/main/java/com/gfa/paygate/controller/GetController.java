package com.gfa.paygate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GetController {

    @GetMapping("/")
    public String show(){
        return "I am alive";
    }
}
