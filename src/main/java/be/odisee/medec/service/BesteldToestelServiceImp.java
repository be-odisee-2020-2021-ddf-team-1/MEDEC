package be.odisee.medec.service;

import be.odisee.medec.dao.BesteldToestelRepository;
import be.odisee.medec.domain.BesteldToestel;
import be.odisee.medec.domain.Planning;
import be.odisee.medec.formdata.BesteldToestelData;

import javax.validation.Valid;
import java.util.List;

public class BesteldToestelServiceImp implements  BesteldToestelService {
    final
    BesteldToestelRepository besteldToestelRepository;
    public BesteldToestelServiceImp(BesteldToestelRepository besteldToestelRepository1){
        this.besteldToestelRepository = besteldToestelRepository1;
    }
    @Override
    public void deleteBesteldToestel(long besteldToestelId) {

    }

    @Override
    public String createBesteldToestel(@Valid BesteldToestelData besteldToestelData) {
        return null;
    }

    @Override
    public BesteldToestel getBesteldToestelById(long besteldToestelId) {
        return null;
    }

    @Override
    public BesteldToestel getBesteldToestelByNaam(String besteldToestelNaam) {
        return null;
    }

    @Override
    public List<BesteldToestel> getBesteldeToestellen() {
        return  besteldToestelRepository.findAll();
    }

    @Override
    public BesteldToestelData prepareNewBesteldToestelData() {
        return null;
    }

    @Override
    public BesteldToestelData prepareEditBesteldToestelData(Planning planning) {
        return null;
    }

    @Override
    public BesteldToestelData prepareBesteldToestelDataToEdit(long plannerId) {
        return null;
    }
}
