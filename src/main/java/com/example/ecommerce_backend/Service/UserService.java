package com.example.ecommerce_backend.Service;

import com.example.ecommerce_backend.api.model.RegistrationBody;
import com.example.ecommerce_backend.exception.UserAlreadyExistsException;
import com.example.ecommerce_backend.model.DAO.LocalUserDAO;
import com.example.ecommerce_backend.model.LocalUser;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public LocalUserDAO localUserDAO;

    public UserService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {

        if (localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setUsername(registrationBody.getUsername());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        //TODO: Encrypt passwords!!
        user.setPassword(registrationBody.getPassword());
        user = localUserDAO.save(user);
        return user;
    }
}
