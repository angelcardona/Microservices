package com.marketplace.users.domain.exceptions;

public class DuplicateUserNameException extends RuntimeException {
    public DuplicateUserNameException(String email){
        super("El Usuario con el" + email + " ya existe");
    }

}
