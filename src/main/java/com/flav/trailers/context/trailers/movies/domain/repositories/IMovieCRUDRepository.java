package com.flav.trailers.context.trailers.movies.domain.repositories;

import com.flav.trailers.commons.model.Pagination;
import com.flav.trailers.context.trailers.movies.domain.DTOs.responseDto.MoviePagination;
import com.flav.trailers.context.trailers.movies.domain.models.Movie;

import java.util.Optional;

public interface IMovieCRUDRepository {

    public MoviePagination findAll(Pagination pagination);
    public boolean findByName(String name);
    public Optional<Movie> findById(Long id);
    public Movie create(Movie movie);
    public Movie update(Movie movie);
    public boolean delete(Long id);

}
