package com.marketplace.users.infrastructure.Configuration;


import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.marketplace.users.domain.exceptions.InvalidUserException;
import com.marketplace.users.domain.exceptions.UserNotFoundException;
import com.marketplace.users.infrastructure.adapters.dto.ErrorResponse;

@ControllerAdvice
public class GlobalHandlerException  {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity <ErrorResponse> handleValidationExceptions(
        MethodArgumentNotValidException e,WebRequest request){
            Map<String,String> errors=new HashMap<>();
            e.getBindingResult().getAllErrors().forEach(error ->{
                String fieldname=((FieldError) error).getField();
                String errorMessage=error.getDefaultMessage();
                errors.put(fieldname, errorMessage);
            });
            ErrorResponse errorResponse= ErrorResponse.builder()
                                        .timestamp(Instant.now())
                                        .status(HttpStatus.BAD_REQUEST.value())
                                        .error("Validation Error")
                                        .message(errors.toString())
                                        .path(request.getDescription(false))
                                        .build();
            return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
        }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity <ErrorResponse> handleUserNotFoundException(
        UserNotFoundException e,WebRequest request){
            ErrorResponse errorResponse= ErrorResponse.builder()
                                        .timestamp(Instant.now())
                                        .status(HttpStatus.BAD_REQUEST.value())
                                        .error("Validation Error")
                                        .message(e.getMessage())
                                        .path(request.getDescription(false))
                                        .build();
            return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        }
    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity <ErrorResponse> handleInvalidUserExceptionn(
        InvalidUserException e,WebRequest request){
            ErrorResponse errorResponse= ErrorResponse.builder()
                                        .timestamp(Instant.now())
                                        .status(HttpStatus.BAD_REQUEST.value())
                                        .error("Validation Error")
                                        .message(e.getMessage())
                                        .path(request.getDescription(false))
                                        .build();
            return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        }

    @ExceptionHandler(Exception.class)
    public ResponseEntity <ErrorResponse> handleInvalidUserExceptionn(
        Exception e,WebRequest request){
            ErrorResponse errorResponse= ErrorResponse.builder()
                                        .timestamp(Instant.now())
                                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                        .error("Undexpected eror try again")
                                        .message(e.getMessage())
                                        .path(request.getDescription(false))
                                        .build();
            return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    


}
