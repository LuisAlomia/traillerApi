package com.flav.trailers.context.trailers.users.infrastructure.config;

import com.flav.trailers.context.trailers.users.domain.exceptions.UserResourceExist;
import com.flav.trailers.context.trailers.users.domain.exceptions.UserResourceNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class uSERControllerAdvanceExceptions {

    @ExceptionHandler(UserResourceNotFound.class)
    public ResponseEntity<String> handleEmptyInput(UserResourceNotFound emptyInputException){
        return new ResponseEntity<>(emptyInputException.getMessage(), emptyInputException.getStatus());
    }

    @ExceptionHandler(UserResourceExist.class)
    public ResponseEntity<String> handleEmptyInput(UserResourceExist emptyInputException){
        return new ResponseEntity<>(emptyInputException.getMessage(), emptyInputException.getStatus());
    }
}
