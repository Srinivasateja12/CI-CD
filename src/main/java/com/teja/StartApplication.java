package com.teja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController  // Use RestController to return plain text or JSON by default
public class StartApplication {

    @GetMapping("/calculate")
    public String calculate(@RequestParam(required = false) Double num1,
                            @RequestParam(required = false) Double num2,
                            @RequestParam(required = false) String operator) {

        if (num1 == null || num2 == null || operator == null) {
            return "Invalid input";
        }

        double result = 0;
        switch (operator) {
            case "add": result = num1 + num2; break;
            case "subtract": result = num1 - num2; break;
            case "multiply": result = num1 * num2; break;
            case "divide":
                if (num2 == 0) return "Cannot divide by zero";
                result = num1 / num2; break;
            default: return "Invalid operator";
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
