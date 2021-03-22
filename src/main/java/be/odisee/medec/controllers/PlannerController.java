package be.odisee.medec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlannerController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

}
