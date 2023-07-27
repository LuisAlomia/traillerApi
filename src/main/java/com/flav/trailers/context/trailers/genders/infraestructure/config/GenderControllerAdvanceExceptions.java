package com.flav.trailers.context.trailers.genders.infraestructure.config;

import com.flav.trailers.context.trailers.genders.domain.exeptions.GenderResourceExist;
import com.flav.trailers.context.trailers.genders.domain.exeptions.GenderResourceNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenderControllerAdvanceExceptions {

    @ExceptionHandler(GenderResourceNotFound.class)
    public ResponseEntity<String> handleEmptyInput(GenderResourceNotFound emptyInputException){
        return new ResponseEntity<>(emptyInputException.getMessage(), emptyInputException.getStatus());
    }

    @ExceptionHandler(GenderResourceExist.class)
    public ResponseEntity<String> handleEmptyInput(GenderResourceExist emptyInputException){
        return new ResponseEntity<>(emptyInputException.getMessage(), emptyInputException.getStatus());
    }
}
