package be.odisee.medec.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
    @Table(name ="PLANNING")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force=true)
public class Planning {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private final long planningId;

    private  String name;

@OneToOne
private final BesteldToestel besteldToestel;

@OneToOne
private final Medewerker medewerker;

@OneToMany final List<Activiteit> activiteit;

}
