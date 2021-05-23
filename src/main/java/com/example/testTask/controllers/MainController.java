package com.example.testTask.controllers;

import data.jdbc.App;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import data.jdbc.App;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("data1", App.output);
        model.addAttribute("title", "Главная страница");
        return "home";
    }

}
