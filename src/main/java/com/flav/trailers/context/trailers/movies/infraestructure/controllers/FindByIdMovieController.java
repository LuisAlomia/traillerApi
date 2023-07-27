package com.flav.trailers.context.trailers.movies.infraestructure.controllers;

import com.flav.trailers.context.trailers.movies.application.FindByIdMovieUseCase;
import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movies")
public class FindByIdMovieController {

    private final FindByIdMovieUseCase useCase;

    public FindByIdMovieController(FindByIdMovieUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findOne(@PathVariable("id") Long id) {
        Movie data = useCase.run(id);

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
}
