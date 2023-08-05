package com.flav.trailers.context.trailers.movies.infrastructure.config;

import com.flav.trailers.context.trailers.movies.domain.exceptions.ErrorArgumentException;
import com.flav.trailers.context.trailers.movies.domain.exceptions.MovieResourceExist;
import com.flav.trailers.context.trailers.movies.domain.exceptions.MovieResourceNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieControllerAdvanceExceptions {

    @ExceptionHandler(MovieResourceNotFound.class)
    public ResponseEntity<String> handleEmptyInput(MovieResourceNotFound emptyInputException){
        return new ResponseEntity<>(emptyInputException.getMessage(), emptyInputException.getStatus());
    }

    @ExceptionHandler(MovieResourceExist.class)
    public ResponseEntity<String> handleEmptyInput(MovieResourceExist emptyInputException){
        return new ResponseEntity<>(emptyInputException.getMessage(), emptyInputException.getStatus());
    }

    @ExceptionHandler(ErrorArgumentException.class)
    public ResponseEntity<String> handleEmptyInput(ErrorArgumentException emptyInputException){
        return new ResponseEntity<>(emptyInputException.getMessage(), emptyInputException.getStatus());
    }


}
