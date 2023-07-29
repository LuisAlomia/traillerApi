package com.flav.trailers.context.users.domain.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class UserResourceExist extends RuntimeException {

    private String message;
    private HttpStatus status;

    public UserResourceExist(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
