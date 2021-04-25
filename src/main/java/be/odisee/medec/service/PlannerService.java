package be.odisee.medec.service;

import be.odisee.medec.domain.Medewerker;
import be.odisee.medec.domain.Planning;
import be.odisee.medec.formdata.ActiviteitData;
import be.odisee.medec.formdata.PlannerData;

import javax.validation.Valid;
import java.util.List;

public interface PlannerService {

     PlannerData prepareNewPlannerData();

     ActiviteitData preparenewActiviteitData();

     String CreatePlanner(@Valid PlannerData plannerData);

     Planning getPlanningById(long planningId);

     void deletePlanning(long planningId);

     List<Planning> getPlannings();

     PlannerData prepareEditPlannerData(Planning planning);

     PlannerData preparePlannerDataToEdit(long plannerId);

      List<Medewerker> getMedewerkers();
}
