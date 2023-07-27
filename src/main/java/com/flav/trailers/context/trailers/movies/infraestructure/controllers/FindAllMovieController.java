package com.flav.trailers.context.trailers.movies.infraestructure.controllers;

import com.flav.trailers.context.trailers.movies.application.FindAllMovieUseCase;
import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class FindAllMovieController {

    private final FindAllMovieUseCase useCase;

    public FindAllMovieController(FindAllMovieUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        List<Movie> data = useCase.run();

        return  ResponseEntity.status(HttpStatus.OK).body(data);
    }
}
