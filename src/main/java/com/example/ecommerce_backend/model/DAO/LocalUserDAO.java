package com.example.ecommerce_backend.model.DAO;

import com.example.ecommerce_backend.model.LocalUser;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface LocalUserDAO extends CrudRepository<LocalUser, Long> {

    Optional<LocalUser> findByUsernameIgnoreCase(String username);

    Optional<LocalUser> findByEmailIgnoreCase(String email);
}
