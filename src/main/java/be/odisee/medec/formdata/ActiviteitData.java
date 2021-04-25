package be.odisee.medec.formdata;
import be.odisee.medec.domain.Medewerker;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.sql.Time;
import java.util.Date;
import java.util.List;
@Data
public class ActiviteitData {

    private long activiteitId=0;
    private long planningId = 0;
    @NotBlank(message="Name mag niet leeg zijn")
    private String name;
    @NotBlank(message="Selecteer een datum")
    private Date datum;
    @NotBlank(message="Selecteer een startTijd")
    private Time startTijd;
    @NotBlank(message="Selecteer een eindTijd")
    private Time eindTijd;
    @NotBlank(message="Kies een medewerker")
    private Medewerker medewerker;
    @NotBlank(message="je moet een soort activiteit kiezen")
    private String type;
    private List<Medewerker> medewerkerList;
}