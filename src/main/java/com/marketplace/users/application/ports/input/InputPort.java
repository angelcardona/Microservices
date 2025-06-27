package com.marketplace.users.application.ports.input;

import java.util.List;

import com.marketplace.users.domain.User;

public interface InputPort {
    User registerUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
    User update(Long id, User user);


}
