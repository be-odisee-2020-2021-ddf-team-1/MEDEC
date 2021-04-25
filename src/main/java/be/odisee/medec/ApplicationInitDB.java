package be.odisee.medec;

import be.odisee.medec.dao.PlanningRepository;
import be.odisee.medec.dao.UserRepository;
import be.odisee.medec.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class ApplicationInitDB implements CommandLineRunner {

    @Autowired
    PlanningRepository planningRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        List<User> users = Arrays.asList(
        new User(1, "Jimmy",
                "{bcrypt}$2a$10$2o9Frax4HHJLEMMb5iKs9ONs8zEmGv51IRIURY8PkBk7GsCxy4ixO",
                "ROLE_ADMIN","Imke", "Courtois","imke@courtois.be"),
                new User(1, "Jan",
                        "{bcrypt}$2a$10$2o9Frax4HHJLEMMb5iKs9ONs8zEmGv51IRIURY8PkBk7GsCxy4ixO",
                        "ROLE_USER","Imke", "Courtois","imke@courtois.be"));

        for (User user: users) {

            //userRepository.save(user);
        };
    }
}