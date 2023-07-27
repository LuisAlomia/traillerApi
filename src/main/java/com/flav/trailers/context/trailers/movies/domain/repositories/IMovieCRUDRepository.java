package com.flav.trailers.context.trailers.movies.domain.repositories;

import com.flav.trailers.context.trailers.movies.domain.models.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieCRUDRepository {

    public List<Movie> findAll();
    public boolean findByName(String name);
    public Optional<Movie> findById(Long id);
    public Movie create(Movie movie);
    public Movie update(Movie movie);
    public boolean delete(Long id);

}
