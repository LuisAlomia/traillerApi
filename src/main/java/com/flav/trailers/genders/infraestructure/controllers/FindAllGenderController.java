package com.flav.trailers.genders.infraestructure.controllers;

import com.flav.trailers.genders.application.FindAllGenderUseCase;
import com.flav.trailers.genders.domain.models.Gender;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genders")
public class FindAllGenderController {

    private final FindAllGenderUseCase useCase;

    public FindAllGenderController(FindAllGenderUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public ResponseEntity<List<Gender>> findAll() {
        List<Gender> data = useCase.run();

        return  ResponseEntity.status(HttpStatus.OK).body(data);
    }
}
