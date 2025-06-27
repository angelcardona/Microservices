package com.marketplace.users.domain.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException (Long id){
        super("Usuario con id" + id + "No encontrado");
    }

}
