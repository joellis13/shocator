package com.example.shocator.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    static String title = "Shocator";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", title);
        return "index";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String searchResults(@RequestParam(value = "phrase") String phrase, Model model) {
        String message = "You searched for '" + phrase + ".'";

        model.addAttribute("message", message);
        model.addAttribute("title", title);

        return "search";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String processSearch(@RequestParam String phrase, Model model) {

        return "redirect:/search?phrase=" + phrase;
    }

}
