package be.odisee.medec.controllers;

import be.odisee.medec.formdata.PlannerData;
import be.odisee.medec.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/planning")
public class PlannerController {

    @Autowired
    private PlannerService plannerService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping
    public String showPlanningForm(Model model){
        model.addAttribute("plannerData",plannerService.prepareNewPlannerData());
        model.addAttribute("plannings",plannerService.getPlannings()) ;
        return "planning";
    }

@GetMapping("/edit")

public String planningEditForm(@RequestParam("planningId") long planningId, Model model){

        PlannerData plannerData = plannerService.preparePlannerDataToEdit(planningId);
        prepareForm(plannerData,model);
        model.addAttribute("message", "Update or Delete this planning - or cancel");

        return "planning";

}

    @PostMapping(params = "submit") // refereer naar de submit button van de HTMLpagina
    public String processPlanningForm(@Valid PlannerData plannerData, Errors errors, Model model) {
        String message = "";

        try {
            if (errors.hasErrors()) {
                message = "Correct input errors, please";
                throw new IllegalArgumentException();
            } else {

                message = plannerService.CreatePlanner(plannerData);
                plannerData = plannerService.prepareNewPlannerData();
            }

        } catch (IllegalArgumentException e) {

        }
        prepareForm(plannerData, model);
        model.addAttribute("message", message);

        return "planning";

    }

    @PostMapping(params = "delete")
    public String deletePlanning(PlannerData plannerData, Model model){
        plannerService.deletePlanning(plannerData.getPlanningId());

        PlannerData newPlannerData = plannerService.prepareNewPlannerData();
        prepareForm(newPlannerData,model);
        model.addAttribute("message", "Sucessfully deleted Entry" +plannerData.getName());
        return "planning";
    }


    private void prepareForm(PlannerData plannerData, Model model) {
        model.addAttribute("plannerData",plannerData);
    }





}
