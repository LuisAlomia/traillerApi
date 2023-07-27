package com.flav.trailers.context.trailers.movies.application;

import com.flav.trailers.context.trailers.movies.domain.exceptions.MovieResourceNotFound;
import com.flav.trailers.context.trailers.movies.domain.repositories.IMovieCRUDRepository;
import com.flav.trailers.context.trailers.movies.domain.constants.MovieConstants;
import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class FindByIdMovieUseCase {

    private final IMovieCRUDRepository repo;

    public FindByIdMovieUseCase(IMovieCRUDRepository repo) {
        this.repo = repo;
    }

    public Movie run(Long id) {
        Optional<Movie> movie = repo.findById(id);

        if(movie.isEmpty()) {
            throw new MovieResourceNotFound(String.format(MovieConstants.MOVIE_NOT_FOUND, id), HttpStatus.NOT_FOUND);
        }

        return movie.get();
    }

}
