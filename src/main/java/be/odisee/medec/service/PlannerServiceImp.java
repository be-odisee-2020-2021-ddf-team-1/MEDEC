package be.odisee.medec.service;

import be.odisee.medec.dao.ActiviteitRepository;
import be.odisee.medec.dao.MedewerkerRepository;
import be.odisee.medec.dao.PlanningRepository;
import be.odisee.medec.domain.Medewerker;
import be.odisee.medec.domain.Planning;
import be.odisee.medec.formdata.ActiviteitData;
import be.odisee.medec.formdata.PlannerData;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class PlannerServiceImp implements PlannerService {

final
PlanningRepository planningRepository;
final
ActiviteitRepository activiteitRepository;
final
MedewerkerRepository medewerkerRepository;


    public PlannerServiceImp(PlanningRepository planningRepository, ActiviteitRepository activiteitRepository, MedewerkerRepository medewerkerRepository) {
        this.planningRepository = planningRepository;
        this.activiteitRepository = activiteitRepository;
        this.medewerkerRepository = medewerkerRepository;
    }

    //Create operation
    // Lege plannerData (form)

    @Override
    public  ActiviteitData preparenewActiviteitData(){
     ActiviteitData model = new ActiviteitData();
     model.setMedewerkerList(getMedewerkers());
        return model;
    }




    @Override
    public PlannerData prepareNewPlannerData(){
        return new PlannerData();
    }


    @Override
    public PlannerData preparePlannerDataToEdit(long plannerId){
        Planning planning = planningRepository.findByplanningId(plannerId);

        //  volgens vb van Hans , plannerData.SetPlannerId(plannerId) -> wrm ? want in prepareEdit setten wij al de meegeven ID ??

        return prepareEditPlannerData(planning);

    }

    // Van een model naar een ViewModel -> mapper
    @Override
    public PlannerData prepareEditPlannerData(Planning planning){

        PlannerData plannerData = new PlannerData();

        if(planning != null){
            plannerData.setPlanningId(planning.getPlanningId());
            plannerData.setName(planning.getName());
        }
        else
            {
            plannerData.setPlanningId(0);
            plannerData.setName("");
        }

        return plannerData;
    }

    // Object Planning instancieren -> gegevens uit form mappen naar nieuwe instance
    // instance Planning persisteren naar db via DAO ( planningRepository).

    // Create of Update

    // Viewmodel -> model -> Db

    // Valid viewmodel -> Dao-> om opteslaan in DV

    @Override
    public String CreatePlanner(@Valid PlannerData plannerData){

        Planning planning;

        if(plannerData.getPlanningId() == 0)
        {
            planning = new Planning();
        }
        else
        {
            planning = planningRepository.findByplanningId(plannerData.getPlanningId());
        }

        planning.setName(plannerData.getName());

        planningRepository.save(planning);

        return planning.toString() + "Has been processed";
    }

    // Read operation

    @Override
    public Planning getPlanningById(long planningId){
        return planningRepository.findByplanningId(planningId);

    }
    @Override
    public Planning getPlanningByNaam(String planningNaam){

        return  planningRepository.findByName(planningNaam);
    }

    @Override
    public List<Planning> getPlannings(){
        return planningRepository.findAllByOrderByName();
    }

    @Override
    public List<Medewerker> getMedewerkers(){
        return medewerkerRepository.findAll();
    }

    // Waarom ?

    // Delete operation

    @Override
    public void deletePlanning(long planningId){
        Planning planning = planningRepository.findByplanningId(planningId);
        planningRepository.delete(planning);

    }


}