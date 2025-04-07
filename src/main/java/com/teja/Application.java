package com.teja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class StartApplication {

    @GetMapping("/")
    public String index(@RequestParam double num1, @RequestParam double num2, @RequestParam String operator, Model model) {
        model.addAttribute("title", "I have successfuly built a sprint boot application using Maven");
        model.addAttribute("msg", "This application is deployed on to Kubernetes using Azure DevOps");
        double result = 0;
        switch (operator) {
            case "add": result = num1 + num2; break;
            case "subtract": result = num1 - num2; break;
            case "multiply": result = num1 * num2; break;
            case "divide": result = (num2 != 0) ? num1 / num2 : 0; break;
        }
        model.addAttribute("result", result);   
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}