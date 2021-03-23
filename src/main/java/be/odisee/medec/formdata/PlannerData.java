package be.odisee.medec.formdata;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PlannerData {

    // Id is nodig voor updaten.

    private long planningId=0;

    @NotBlank(message="Name cannot be empty")
    private String name;

}
