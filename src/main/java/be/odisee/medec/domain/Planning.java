package be.odisee.medec.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PLANNING")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force=true)
public class Planning {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final long planningId;

    private  String name;


}
