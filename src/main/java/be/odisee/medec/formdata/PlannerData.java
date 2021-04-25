package be.odisee.medec.formdata;
import javax.validation.constraints.NotBlank;

import be.odisee.medec.domain.Activiteit;
import lombok.Data;

import java.util.List;

@Data
public class PlannerData {

    // Id is nodig voor updaten.

    private long planningId=0;

    @NotBlank(message="Name cannot be empty")

    private String name;

    private List<Activiteit> activiteitList;

}
