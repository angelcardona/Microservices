package com.marketplace.users.application.ports.output;

import java.util.List;
import java.util.Optional;

import com.marketplace.users.domain.User;

public interface OutputPort {
    User saveUser(User user);
    Optional <User> findById(Long id);
    List<User>findAll();
    void deleteUser(Long Id);
    

}
