package com.aynu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexHandler {

    @GetMapping("/{url}")
    public String index(@PathVariable("url") String url){
        return url;
    }

    @GetMapping(value = {"/","login"})
    public String login(){
        return "login";
    }
}
