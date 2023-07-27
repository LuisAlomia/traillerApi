package com.flav.trailers.context.trailers.movies.application;


import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import com.flav.trailers.context.trailers.movies.domain.repositories.IMovieCRUDRepository;

import java.util.List;

public class FindAllMovieUseCase {

    private final IMovieCRUDRepository repo;

    public FindAllMovieUseCase(IMovieCRUDRepository repo) {
        this.repo = repo;
    }

    public List<Movie> run() {
        return  repo.findAll();
    }

}
