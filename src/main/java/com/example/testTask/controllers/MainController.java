package com.example.testTask.controllers;

import com.example.testTask.models.Securities;
import com.example.testTask.repo.SecuritiesRepository;
import data.jdbc.App;
import org.h2.store.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import data.jdbc.App;

@Controller
public class MainController {

    @Autowired
    private SecuritiesRepository securitiesRepository;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Securities> securities = securitiesRepository.findAll();
        model.addAttribute("securities", securities);
        model.addAttribute("data1", App.output);
        model.addAttribute("title", "Главная страница");
        return "home";
    }

}
