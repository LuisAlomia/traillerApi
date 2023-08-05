package com.flav.trailers.context.trailers.genders.infrastructure.controllers;

import com.flav.trailers.context.trailers.genders.application.FindByIdGenderUseCase;
import com.flav.trailers.context.trailers.genders.domain.models.Gender;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/genders")
public class FindByIdGenderController {

    private final FindByIdGenderUseCase useCase;

    public FindByIdGenderController(FindByIdGenderUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gender> findOne(@PathVariable("id") Long id) {
        Gender data = useCase.run(id);

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
}
