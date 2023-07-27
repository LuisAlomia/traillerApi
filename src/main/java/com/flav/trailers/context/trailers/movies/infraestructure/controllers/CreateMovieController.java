package com.flav.trailers.context.trailers.movies.infraestructure.controllers;

import com.flav.trailers.context.trailers.movies.application.CreateMovieUseCase;
import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class CreateMovieController {

    private final CreateMovieUseCase useCase;

    public CreateMovieController(CreateMovieUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody Movie movie) {
        Movie data = useCase.run((movie));

        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
}
