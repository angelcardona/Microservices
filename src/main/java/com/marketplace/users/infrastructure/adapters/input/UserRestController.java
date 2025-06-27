package com.marketplace.users.infrastructure.adapters.input;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.users.application.ports.input.InputPort;
import com.marketplace.users.domain.User;
import com.marketplace.users.infrastructure.adapters.input.mapper.UserRestMapper;
import com.marketplace.users.infrastructure.adapters.input.model.request.UserCreateRequest;
import com.marketplace.users.infrastructure.adapters.input.model.response.UserResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController {

    private final InputPort port;
    private final UserRestMapper mapper;

    @GetMapping("/api")
    public List<UserResponse> findAll(){
        return mapper.toUserResponseList(port.getAllUsers());

    }

    @GetMapping("api/{id}")
    private UserResponse getUserbyId(@PathVariable Long id){
        return mapper.toUserResponse(port.getUserById(id));
    }

    @PostMapping // Don't forget this annotation for POST requests!
    public ResponseEntity<UserResponse> save(@Valid @RequestBody UserCreateRequest request) {
   
    User userToRegister = mapper.toDomainUser(request);
    User registeredUser = port.registerUser(userToRegister);
    UserResponse response = mapper.toUserResponse(registeredUser);

   
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("api/{id}")
    public void delete(@PathVariable Long id){
        port.deleteUser(id);
    }
}
