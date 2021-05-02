package be.odisee.medec.service;

import be.odisee.medec.dao.BesteldToestelRepository;
import be.odisee.medec.domain.BesteldToestel;
import be.odisee.medec.domain.Planning;
import be.odisee.medec.formdata.BesteldToestelData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;
@Service("besteldToestelService")
public class BesteldToestelServiceImp implements  BesteldToestelService {
    final
    BesteldToestelRepository besteldToestelRepository;


    public BesteldToestelServiceImp(BesteldToestelRepository besteldToestelRepository) {
        this.besteldToestelRepository = besteldToestelRepository;
    }

    @Override
    public void deleteBesteldToestel(long besteldToestelId) {
        BesteldToestel toestel = besteldToestelRepository.findByBesteldToestelId(besteldToestelId);
        if (toestel != null)
        besteldToestelRepository.delete(toestel);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public String createBesteldToestelData(@Valid BesteldToestelData toestelData) {
        BesteldToestel toestel;

        if(toestelData.getBesteldToestelId() == 0)
        {
            toestel = new BesteldToestel();
        }
        else
        {
            toestel = besteldToestelRepository.findByBesteldToestelId(toestelData.getBesteldToestelId());
        }
        // toestel ppts aanvullen
        toestel.setNaam(toestelData.getNaam());
        Date aankoopdatum = new Date(toestelData.getAankoopdatum());
        toestel.setAankoopdatum(aankoopdatum);
        toestel.setPrijs(toestelData.getPrijs());
        // bestelde toestel bewaren
        besteldToestelRepository.save(toestel);

        return "Toestel "+ toestel.getNaam() + " with id - " + toestel.getbesteldToestelId() + " has been correctly processed";
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public BesteldToestel createBesteldToestel(BesteldToestel toestel) {

        return besteldToestelRepository.save(toestel);
    }
    @Override
    public void UpdateBesteldToestel(BesteldToestel toestel) {
        BesteldToestel toEdit = besteldToestelRepository.findByBesteldToestelId(toestel.getbesteldToestelId());
        toEdit.setNaam(toestel.getNaam());
        toEdit.setAankoopdatum(toestel.getAankoopdatum());
        toEdit.setPrijs(toestel.getPrijs());
        besteldToestelRepository.save(toEdit);
    }

    @Override
    public BesteldToestel getBesteldToestelById(long besteldToestelId) {
        return besteldToestelRepository.findByBesteldToestelId(besteldToestelId);
    }

    @Override
    public List<BesteldToestel> getBesteldeToestellen() {
        return  besteldToestelRepository.findAll();
    }

    @Override
    public BesteldToestelData prepareNewBesteldToestelData() { return new BesteldToestelData(); }

    @Override
    public BesteldToestelData prepareEditBesteldToestelData(BesteldToestel toestel) {
        BesteldToestelData toestelData = new BesteldToestelData();
        if(toestel != null){
            toestelData.setBesteldToestelId(toestel.getbesteldToestelId());
            toestelData.setNaam(toestel.getNaam());
            toestelData.setAankoopdatum(toestel.getAankoopdatum().getTime());
            toestelData.setPrijs(toestel.getPrijs());
        }
        else{
            toestelData.setBesteldToestelId(0);
            toestelData.setNaam("");
            toestelData.setAankoopdatum(null);
            toestelData.setPrijs(0);
        }
        return toestelData;
    }

    @Override
    public BesteldToestelData prepareBesteldToestelDataToEdit(long toestelId) {
        BesteldToestel toestel = besteldToestelRepository.findByBesteldToestelId(toestelId);
        return prepareEditBesteldToestelData(toestel);
    }
}
