package com.flav.trailers.context.trailers.users.domain.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
public class UserResourceNotFound extends RuntimeException {

    private String message;
    private HttpStatus status;

    public UserResourceNotFound(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
