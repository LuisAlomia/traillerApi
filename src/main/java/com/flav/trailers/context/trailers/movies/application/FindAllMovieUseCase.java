package com.flav.trailers.context.trailers.movies.application;

import com.flav.trailers.commons.model.Pagination;
import com.flav.trailers.context.trailers.movies.domain.DTOs.responseDto.MoviePagination;
import com.flav.trailers.context.trailers.movies.domain.repositories.IMovieCRUDRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;

@Log4j2
public class FindAllMovieUseCase {

    private final IMovieCRUDRepository repo;

    public FindAllMovieUseCase(IMovieCRUDRepository repo) {
        this.repo = repo;
    }

    @Cacheable("movies")
    public MoviePagination run(Pagination pagination) {
        log.info("Successful request in class | FindAllMovieUseCase |");
        return  repo.findAll(pagination);
    }

}
