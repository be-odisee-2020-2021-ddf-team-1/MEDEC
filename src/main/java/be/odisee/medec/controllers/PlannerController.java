package be.odisee.medec.controllers;

import be.odisee.medec.domain.Medewerker;
import be.odisee.medec.formdata.PlannerData;
import be.odisee.medec.service.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/planning")
public class PlannerController {


    /*
     Autowired zorgt voor onze dependancy injection van onze Service in onze controller
     Alternatief als autoWired niet gebruiker is als volgens :

     private final PlannerService plannerService;

    public PlannerController(PlannerService plannerService) {
        this.plannerService = plannerService;
    }
     */

    @Autowired
    private PlannerService plannerService;


    // Overview met alle planning
    // Pagina voor aanmaken
    // Pagina voor editen
    // Deleten via actions geen nieuwe pagina
    // Pagina voor details

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @GetMapping("/login-error")
    public String loginerror(Model model) {
        model.addAttribute("error", true);
        return "login";
    }

    // overview van alle planningen
    @GetMapping("/Overview")
    public String showListPlanning(Model model){
        model.addAttribute("plannings",plannerService.getPlannings()) ;
        System.out.printf("%s is {bcrypt}%s%n", "Jimmy123", hash("Jimmy123"));
        System.out.printf("%s is {bcrypt}%s%n", "Jan123", hash("Jan123"));

        return "planning";
    }

    @GetMapping("/Createactiviteit")
    public String showCreateActiviteitForm(@RequestParam("planningId") long planningId,Model model){
        List<Medewerker> mdwks =  plannerService.getMedewerkers();
        model.addAttribute("mdwk", mdwks);
        model.addAttribute("Activiteit",plannerService.preparenewActiviteitData());
        model.addAttribute("planningId",planningId);
        return "CreateActiviteit";
    }

    // Create pagina
    @GetMapping("/CreatePlanning")
    public String showCreatePlanningForm(Model model){
        model.addAttribute("plannerData",plannerService.prepareNewPlannerData());
        return "CreatePlanning";
    }

    // Detail pagina
    @GetMapping("/Detailsplanning")
    public String showDetailPlanning(@RequestParam("planningId") long planningId, Model model){
        model.addAttribute("plannerData",plannerService.getPlanningById(planningId));

        return "DetailPlanning";
    }

    @GetMapping("/Editplanning")

    public String planningEditForm(@RequestParam("planningId") long planningId, Model model){

        PlannerData plannerData = plannerService.preparePlannerDataToEdit(planningId);
        prepareForm(plannerData,model);
        model.addAttribute("message", "Update or Delete this planning - or cancel");

        return "EditPlanning";

}

    @PostMapping("/CreatePlanning")
    public String processPlanningForm(@Valid PlannerData plannerData, Errors errors, Model model) {
        String message = "";

        try {
            if (errors.hasErrors()) {
                message = "Correct input errors, please";
                return "CreatePlanning";
            } else {

                message = plannerService.CreatePlanner(plannerData);
                plannerData = plannerService.prepareNewPlannerData();
                return  "redirect:/planning/";

            }

        } catch (IllegalArgumentException ignored) {

        }
        prepareForm(plannerData, model);
        model.addAttribute("message", message);

        return "redirect:Overview";

    }

    @PostMapping("/Editplanning")
    public String processEditPlanningForm(@Valid PlannerData plannerData, Errors errors, Model model) {
        String message = "";

        try {
            if (errors.hasErrors()) {
                message = "Correct input errors, please";
                throw new IllegalArgumentException();
            } else {

                message = plannerService.CreatePlanner(plannerData);
                plannerData = plannerService.prepareNewPlannerData();
            }

        } catch (IllegalArgumentException ignored) {

        }
        prepareForm(plannerData, model);
        model.addAttribute("message", message);

        return "redirect:Overview";

    }

    @GetMapping("/deletePlanning")
    public String deletePlanning(@RequestParam("planningId") long planningId){
        plannerService.deletePlanning(planningId);

        return "redirect:Overview";
    }

    private void prepareForm(PlannerData plannerData, Model model) {
        model.addAttribute("plannerData",plannerData);
    }





}
