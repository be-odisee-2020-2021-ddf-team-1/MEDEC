package be.odisee.medec.service;

import be.odisee.medec.dao.PlanningRepository;
import be.odisee.medec.domain.Planning;
import be.odisee.medec.formdata.PlannerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class PlannerServiceImp implements PlannerService {

@Autowired
    PlanningRepository planningRepository;


     //Create operation

    // Lege plannerData (form)

    @Override
    public PlannerData prepareNewPlannerData(){

        PlannerData plannerData = new PlannerData();

        return plannerData;

    }

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
        Planning planning = planningRepository.findByplanningId(planningId);
        return planning;

    }

    @Override
    public List<Planning> getPlannings(){
        return planningRepository.findAllByOrderByName();
    }

    @Override
    public PlannerData preparePlannerDataToEdit(long plannerId){
        Planning planning = planningRepository.findByplanningId(plannerId);
        PlannerData plannerData = prepareEditPlannerData(planning) ;

    //  volgens vb van Hans , plannerData.SetPlannerId(plannerId) -> wrm ? want in prepareEdit setten wij al de meegeven ID ??

        return plannerData;

    }


    // Delete operation

    @Override
    public void deletePlanning(long planningId){
        Planning planning = planningRepository.findByplanningId(planningId);
        planningRepository.delete(planning);
    }


}