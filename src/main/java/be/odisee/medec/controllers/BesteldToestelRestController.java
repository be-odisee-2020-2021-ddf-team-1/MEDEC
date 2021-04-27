package be.odisee.medec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BesteldToestelRestController {
    @RequestMapping("/pickitup.html")
    public String pickitup(){
        return "pickitup";
    }
}
