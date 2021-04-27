package be.odisee.medec.controllers;

import be.odisee.medec.domain.BesteldToestel;
import be.odisee.medec.service.BesteldToestelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/besteldtoestel")
public class BesteldToestelRestController {
    @Autowired
    protected BesteldToestelService besteldToestelService; // ready for dependency injection

    @RequestMapping("/OverviewBesteldeToestellen.html")
    public String OverviewBesteldeToestellen(){
        return "OverviewBesteldeToestellen";
    }
    @RequestMapping("/CreateBesteldToestel.html")
    public String CreateBesteldToestel(){
        return "CreateBesteldToestel";
    }
    @RequestMapping("/DetailBesteldToestel/{id}.html")
    public String DetailBesteldToestel(){
        return "DetailBesteldToestel";
    }


    @RequestMapping(value={"/besteldetoestellen"},method= RequestMethod.GET)
    public @ResponseBody
    List<BesteldToestel> getBesteldeToestellen(){

        return besteldToestelService.getBesteldeToestellen();
    }
    @RequestMapping(value={"/besteldtoesteldetails/{id}"},method=RequestMethod.GET)
    public @ResponseBody BesteldToestel getToestel(@PathVariable("id") Integer id) {
        System.out.println("id = " + id);
        return besteldToestelService.getBesteldToestelById(id);
    }
    @RequestMapping(value={"/deleteBesteldToestel/{id}"},method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersoon(@PathVariable("id") Integer id){

        besteldToestelService.deleteBesteldToestel(id);
    }
    //@RequestMapping(value={"/deleteBesteldToestel/{id}"},method=RequestMethod.GET)
    //public @ResponseBody BesteldToestel getToestel(@PathVariable("id") Integer id) {
    // System.out.println("id = " + id);
    //    return besteldToestelService.getBesteldToestelById(id);
    //}
    //@RequestMapping(value={"/createBesteldToestel/"},method=RequestMethod.GET)
    //public @ResponseBody BesteldToestel getToestel(@PathVariable("id") Integer id) {
    //    System.out.println("id = " + id);
    //    return besteldToestelService.getBesteldToestelById(id);
    //}

}
