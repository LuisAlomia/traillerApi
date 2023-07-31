package com.flav.trailers.context.trailers.movies.application;

import com.flav.trailers.commons.model.Pagination;
import com.flav.trailers.context.trailers.movies.domain.DTOs.responseDto.MoviePagination;
import com.flav.trailers.context.trailers.movies.domain.repositories.IMovieCRUDRepository;

public class FindAllMovieUseCase {

    private final IMovieCRUDRepository repo;

    public FindAllMovieUseCase(IMovieCRUDRepository repo) {
        this.repo = repo;
    }

    public MoviePagination run(Pagination pagination) {
        return  repo.findAll(pagination);
    }

}
