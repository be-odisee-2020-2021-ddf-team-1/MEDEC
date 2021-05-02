package be.odisee.medec.formdata;

import be.odisee.medec.domain.Activiteit;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;
@Data
public class BesteldToestelData {

    private long besteldToestelId = 0;
    @NotBlank(message="Naam kan niet leeg zijn")
    private String naam;
    @NotNull(message="Aankoopdatum is verplicht")
    private Long aankoopdatum;
    @Range(min = 0, message = "De prijs moet groter zijn dan 0  ")
    private double prijs;}
