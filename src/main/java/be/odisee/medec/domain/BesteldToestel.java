package be.odisee.medec.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name ="BESTELDTOESTEL")
@Data
@RequiredArgsConstructor
@XmlRootElement(name="besteldtoestel")
@NoArgsConstructor(force=true)
public class BesteldToestel implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final long besteldToestelId;

    private String naam;

    private Date aankoopdatum;

    private double prijs;


    @XmlElement(name="besteldToestelId")
    public long getbesteldToestelId() {
        return besteldToestelId;
    }

    @XmlElement(name="naam")
    public String getNaam() {
        return naam;
    }

    @XmlElement(name="aankoopdatum")
    public Date getAankoopdatum() {
        return aankoopdatum;
    }

    @XmlElement(name="prijs")
    public double getPrijs() {
        return prijs;
    }


}
