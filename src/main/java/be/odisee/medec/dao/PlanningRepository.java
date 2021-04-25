package be.odisee.medec.dao;

import be.odisee.medec.domain.Planning;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlanningRepository extends CrudRepository<Planning,Long> {

    // hier moet men geen methods implementeren voor standaard CRUD sinds zij automatisch gegeneerd zullen worden door Spring Data JPA
    // https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html

     Planning findByplanningId(long planningId);

     List<Planning> findAllByOrderByName();

     Planning findByName(String name);

}
