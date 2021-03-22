package be.odisee.medec.formdata;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PlannerData {

    @NotBlank(message="Name cannot be empty")
    private String name;

}
