package be.odisee.medec.dao;

import be.odisee.medec.domain.Activiteit;
import be.odisee.medec.domain.Medewerker;
import be.odisee.medec.domain.Planning;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedewerkerRepository extends CrudRepository<Medewerker,Long> {

    List<Medewerker> findAll();

}
