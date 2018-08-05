package com.example.shocator.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Shocator");
        return "index";
    }
}
