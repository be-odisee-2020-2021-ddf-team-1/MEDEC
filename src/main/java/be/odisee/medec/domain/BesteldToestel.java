package be.odisee.medec.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="BESTELDTOESTEL")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force=true)
public class BesteldToestel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final long besteldToestelId;

    private String naam;

    private Date aankoopdatum;

    private double prijs;

}
