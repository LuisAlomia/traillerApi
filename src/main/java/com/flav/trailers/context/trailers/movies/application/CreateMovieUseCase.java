package com.flav.trailers.context.trailers.movies.application;

import com.flav.trailers.context.trailers.movies.domain.exceptions.MovieResourceExist;
import com.flav.trailers.context.trailers.movies.domain.repositories.IMovieCRUDRepository;
import com.flav.trailers.context.trailers.movies.domain.constants.MovieConstants;
import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import org.springframework.http.HttpStatus;

public class CreateMovieUseCase {

    private final IMovieCRUDRepository repo;

    public CreateMovieUseCase(IMovieCRUDRepository repo) {
        this.repo = repo;
    }

    public Movie run(Movie movie) {
        boolean findMovie = repo.findByName(movie.getName());

        if(findMovie) {
            throw new MovieResourceExist(String.format(MovieConstants.MOVIE_EXITS, movie.getName()), HttpStatus.FOUND);
        }

        return repo.create(movie);
    }

}
