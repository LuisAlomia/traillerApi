package com.flav.trailers.context.trailers.genders.domain.exeptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
public class GenderResourceNotFound extends RuntimeException {

    private String message;
    private HttpStatus status;

    public GenderResourceNotFound(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
