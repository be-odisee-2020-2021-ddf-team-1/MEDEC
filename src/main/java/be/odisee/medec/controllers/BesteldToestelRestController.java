package be.odisee.medec.controllers;

import be.odisee.medec.domain.BesteldToestel;
import be.odisee.medec.service.BesteldToestelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.Date;
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
    public String CreateBesteldToestel(){ return "CreateBesteldToestel"; }
    @RequestMapping("/DetailBesteldToestel/{id}.html")
    public String DetailBesteldToestel(){
        return "DetailBesteldToestel";
    }
    @RequestMapping("/EditBesteldToestel.html")
    public String EditBesteldToestel(){
        return "CreateBesteldToestel";
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


    /*// REST POST ... Aanmaken van een bestelde toestel
    @RequestMapping(value={"/createBesteldToestel"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody BesteldToestel createtoestel( @RequestBody BesteldToestel toestel)
            throws BindException {

        besteldToestelService.createBesteldToestel(toestel);
        return toestel;
    }*/

    //Test Request werkt
    // REST POST ... Aanmaken van een bestelde toestel
    @RequestMapping(value={"/createBesteldToestel"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody BesteldToestel createtoestel(String naam, double prijs, Long aankoopdatumMillis)
            throws BindException {
        BesteldToestel toestel = new BesteldToestel();
        toestel.setNaam(naam);
        if(aankoopdatumMillis != null){
            Date aankoopdatum = new Date(aankoopdatumMillis);
            toestel.setAankoopdatum(aankoopdatum);
        }
        toestel.setPrijs(prijs);
        besteldToestelService.createBesteldToestel(toestel);
        return toestel;
    }


    /*/ REST PUT ... breng de toestand van bestaande resource van de client naar de server
    @RequestMapping(value={"/updatebesteldtoestel/{id}"},method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putPersoon(@PathVariable("id") Integer id, @RequestBody BesteldToestel toestel){

        toestel.setBesteldToestelId(id);
        besteldToestelService.UpdateBesteldToestel(toestel);
    }*/

    //Test werkt zonder prijs
    // REST PUT ... breng de toestand van bestaande resource van de client naar de server
    @RequestMapping(value={"/updatebesteldtoestel/{id}"},method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putToestel(@PathVariable("id") Integer id, String naam, Double prijs, Long aankoopdatumMillis){
        BesteldToestel toestel = new BesteldToestel();
        toestel.setBesteldToestelId(id);
        toestel.setNaam(naam);
        if(aankoopdatumMillis != null){
            Date aankoopdatum = new Date(aankoopdatumMillis);
            toestel.setAankoopdatum(aankoopdatum);
        }
        toestel.setPrijs(prijs);
        besteldToestelService.UpdateBesteldToestel(toestel);
    }




}
