package be.odisee.medec.formdata;

import be.odisee.medec.domain.Activiteit;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
@Data
public class BesteldToestelData {

    private final long besteldToestelId;
    @NotBlank(message="Naam kan niet leeg zijn")
    private String naam;
    @NotBlank(message="Aankoopdatum is veplicht")
    private Date aankoopdatum;
    @Size(min = 0, message = "De prijs moet groter zijn dan ")
    private double prijs;}