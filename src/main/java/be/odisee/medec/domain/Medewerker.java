package be.odisee.medec.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="MEDEWERKER")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force=true)
public class Medewerker {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final long medewerkerId;

    private  String name;

    private String functie;


}
