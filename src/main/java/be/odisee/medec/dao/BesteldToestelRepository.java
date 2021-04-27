package be.odisee.medec.dao;

import be.odisee.medec.domain.BesteldToestel;
import be.odisee.medec.domain.Medewerker;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BesteldToestelRepository extends CrudRepository<BesteldToestel,Long> {
    List<BesteldToestel> findAll();
}
