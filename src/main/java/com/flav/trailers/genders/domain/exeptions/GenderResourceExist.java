package com.flav.trailers.genders.domain.exeptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class GenderResourceExist extends RuntimeException {

    private String message;
    private HttpStatus status;

    public GenderResourceExist(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
