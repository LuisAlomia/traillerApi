package com.flav.trailers.context.trailers.movies.domain.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
public class MovieResourceNotFound extends RuntimeException {

    private String message;
    private HttpStatus status;

    public MovieResourceNotFound(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
