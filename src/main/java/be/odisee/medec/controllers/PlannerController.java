package be.odisee.medec.controllers;

import be.odisee.medec.domain.Planning;
import be.odisee.medec.formdata.PlannerData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.context.ServerPortInfoApplicationContextInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/planning")
public class PlannerController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping
    public String showPlanningEntryForm(Model model){
        model.addAttribute("plannerData",prepareNewPlannerData());
        System.out.println("Get Test");
        return "planning";
    }


    @PostMapping
    public String processPlanningEntryForm(@Valid PlannerData plannerData, Errors errors, Model model) {
        String message = "";
        System.out.println("Post Test");
        System.out.println(model.getAttribute("message"));
        System.out.println(model.getAttribute("plannerData"));
//        try {
//            if (errors.hasErrors()) {
//                message = "Correct input errors, please";
//               // throw new IllegalArgumentException();
//            }
//
//        } catch (IllegalArgumentException e) {
//            // Nothing special needs to be done
//        }
        message= "Blablablabla";

        model.addAttribute("message", message);
        model.addAttribute("plannerData",plannerData);
        System.out.println(model.getAttribute("message"));
        System.out.println(model.getAttribute("plannerData"));

        return "planning";


    }

    private void prepareForm(PlannerData plannerData, Model model) {
        model.addAttribute("plannerData",plannerData);
    }


    private Object prepareNewPlannerData() {

        PlannerData plannerData = new PlannerData();
        plannerData.setName("Alfred");
        return plannerData;

    }


}
