package com.marketplace.users.application.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.marketplace.users.application.ports.input.InputPort;
import com.marketplace.users.application.ports.output.OutputPort;
import com.marketplace.users.domain.User;
import com.marketplace.users.domain.exceptions.UserNotFoundException;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor

public class UserService implements InputPort {

    private final OutputPort outputPort;
    
    @Override
    public User registerUser(User user) {
        return outputPort.saveUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return outputPort.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @Override
    public List<User> getAllUsers() {
        return outputPort.findAll();
    }

    @Override
    public void deleteUser(Long id) {
         outputPort.deleteUser(id);
    }

    @Override
    public User update(Long id, User user) {
        return outputPort.findById(id)
        .map(userdb->{
            userdb.setName(user.getName());
            userdb.setLastName(user.getLastName());
            userdb.setEmail(user.getEmail());
            userdb.setCountry(user.getCountry());
            return outputPort.saveUser(userdb);
            
        })
        .orElseThrow(()-> new UserNotFoundException(id));
            
    }

   
}
