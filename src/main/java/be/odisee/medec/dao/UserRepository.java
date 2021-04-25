package be.odisee.medec.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends CrudRepository<User, Long> {

    // needed for Spring Security
    public User findByUsername(String username);
}
