package com.flav.trailers.context.trailers.movies.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorArgumentException extends RuntimeException{

    private String message;
    private HttpStatus status;

}
