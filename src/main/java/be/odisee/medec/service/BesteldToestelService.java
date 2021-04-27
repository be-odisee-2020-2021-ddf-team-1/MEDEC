package be.odisee.medec.service;

import be.odisee.medec.domain.BesteldToestel;
import be.odisee.medec.domain.Medewerker;
import be.odisee.medec.domain.Planning;
import be.odisee.medec.formdata.ActiviteitData;
import be.odisee.medec.formdata.BesteldToestelData;
import be.odisee.medec.formdata.PlannerData;

import javax.validation.Valid;
import java.util.List;

public interface BesteldToestelService {

    //voids
    void deleteBesteldToestel(long besteldToestelId);

    //strings
    String createBesteldToestel(@Valid BesteldToestelData besteldToestelData);

    //BesteldToestel
    BesteldToestel getBesteldToestelById(long besteldToestelId);

    BesteldToestel getBesteldToestelByNaam(String besteldToestelNaam);

    //List
    List<BesteldToestel> getBesteldeToestellen();


    //BesteldToestelData
    BesteldToestelData prepareNewBesteldToestelData();

    BesteldToestelData prepareEditBesteldToestelData(Planning planning);

    BesteldToestelData prepareBesteldToestelDataToEdit(long plannerId);
}
