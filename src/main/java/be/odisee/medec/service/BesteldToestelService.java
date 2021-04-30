package be.odisee.medec.service;

import be.odisee.medec.domain.BesteldToestel;
import be.odisee.medec.domain.Planning;
import be.odisee.medec.formdata.BesteldToestelData;

import javax.validation.Valid;
import java.util.List;

public interface BesteldToestelService {

    //voids
    void deleteBesteldToestel(long besteldToestelId);

    //strings
    BesteldToestel createBesteldToestelData(@Valid BesteldToestelData besteldToestelData);

    //strings
    BesteldToestel createBesteldToestel( BesteldToestel besteldToestel);

    //BesteldToestel
    BesteldToestel getBesteldToestelById(long besteldToestelId);


    //List
    List<BesteldToestel> getBesteldeToestellen();

    //BesteldToestelData
    BesteldToestelData prepareNewBesteldToestelData();

    BesteldToestelData prepareEditBesteldToestelData(BesteldToestel toestel);

    BesteldToestelData prepareBesteldToestelDataToEdit(long plannerId);

    void UpdateBesteldToestel(BesteldToestel toestel);

}
