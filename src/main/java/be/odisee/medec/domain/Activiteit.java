package be.odisee.medec.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name ="ACTIVITEIT")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force=true)
public class Activiteit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final long activiteitId;

    private Date datum;

    private String status;

    private Time startTijd;

    private Time eindTijd;

    // hoe zullen wij de subtype mappen in ons DB.

    @OneToOne
    private final Medewerker medewerker;


}

