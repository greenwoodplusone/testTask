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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

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

    @PostMapping("/")
    public String securitiesAdd(@RequestParam Integer data_time,
                                @RequestParam String tool,
                                @RequestParam Integer cost,
                                Model model) {
        Securities securities = new Securities(data_time, tool, cost);
        securitiesRepository.save(securities);
        return "redirect:/";
    }

//    @GetMapping("/")
//    public String securitiesAdd(@PathVariable(value = "id") Integer id, Model model) {
//        Optional<Securities> securities = securitiesRepository.findById(id);
//        ArrayList<Securities> res = new ArrayList<>();
//        securities.ifPresent(res::add);
//        model.addAttribute("securities", res);
//        return "home";
//    }
//
//    @PostMapping("/")
//    public String securitiesUpdate(@PathVariable(value = "id") Integer id,
//                                @RequestParam Integer data_time,
//                                @RequestParam String tool,
//                                @RequestParam Integer cost,
//                                Model model) {
//        Securities securities = securitiesRepository.findById(id).orElseThrow();
//        securities.setCost(cost);
//        securities.setData_time(data_time);
//        securities.setTool(tool);
//        securitiesRepository.save(securities);
//
//        return "redirect:/";
//    }

}
