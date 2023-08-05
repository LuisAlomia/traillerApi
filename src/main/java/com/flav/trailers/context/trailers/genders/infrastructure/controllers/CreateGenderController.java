package com.flav.trailers.context.trailers.genders.infrastructure.controllers;

import com.flav.trailers.context.trailers.genders.application.CreateGenderUseCase;
import com.flav.trailers.context.trailers.genders.domain.models.Gender;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/genders")
public class CreateGenderController {

    private final CreateGenderUseCase useCase;

    public CreateGenderController(CreateGenderUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<Gender> crate(@RequestBody Gender gender) {
        Gender data = useCase.run((gender));

        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
}
