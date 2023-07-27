package com.flav.trailers.context.trailers.movies.domain.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class MovieResourceExist extends RuntimeException {

    private String message;
    private HttpStatus status;

    public MovieResourceExist(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
