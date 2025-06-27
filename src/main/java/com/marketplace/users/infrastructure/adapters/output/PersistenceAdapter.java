package com.marketplace.users.infrastructure.adapters.output;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.marketplace.users.application.ports.output.OutputPort;
import com.marketplace.users.domain.User;
import com.marketplace.users.infrastructure.adapters.output.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersistenceAdapter implements OutputPort{
    
    private final UserRepository repository;
    private final UserMapper mapper;
    
    @Override
    public User saveUser(User user) {
      return mapper.toUser(repository.save((mapper.toUserEntity(user))));
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id)
        .map(mapper::toUser);
    }

    @Override
    public List<User> findAll() {
        return mapper.toUserList(repository.findAll());
    }

    @Override
    public void deleteUser(Long Id) {
       repository.deleteById(Id);;
    }

}
