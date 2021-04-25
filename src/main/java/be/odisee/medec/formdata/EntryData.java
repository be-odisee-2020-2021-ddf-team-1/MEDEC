package be.odisee.medec.formdata;
import lombok.Data;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class EntryData {

    // id is needed for updating
    private long id=0;


    private long[] projectIds;
    private long objectiveId;

    @NotBlank(message="Description must be filled in ")
    private String description;

    // HV 25-8-2020 added for security reasons
    private String username;
}
