package com.flav.trailers.context.trailers.movies.application;

import com.flav.trailers.context.trailers.movies.domain.exceptions.MovieResourceNotFound;
import com.flav.trailers.context.trailers.movies.domain.repositories.IMovieCRUDRepository;
import com.flav.trailers.context.trailers.movies.domain.constants.MovieConstants;
import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Log4j2
public class FindByIdMovieUseCase {

    private final IMovieCRUDRepository repo;

    public FindByIdMovieUseCase(IMovieCRUDRepository repo) {
        this.repo = repo;
    }

    @Cacheable("movies")
    public Movie run(Long id) {
        Optional<Movie> movie = repo.findById(id);

        if(movie.isEmpty()) {
            log.info("Request error in class | FindByIdMovieUseCase | movie not found");
            throw new MovieResourceNotFound(String.format(MovieConstants.MOVIE_NOT_FOUND, id), HttpStatus.NOT_FOUND);
        }

        log.info("Successful request in class | FindByIdMovieUseCase |");
        return movie.get();
    }

}
