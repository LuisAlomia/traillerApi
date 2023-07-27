package com.flav.trailers.context.trailers.movies.infraestructure.persistence.JPA;

import com.flav.trailers.context.trailers.movies.domain.repositories.IMovieCRUDRepository;
import com.flav.trailers.context.trailers.movies.infraestructure.persistence.entities.MovieEntity;
import com.flav.trailers.context.trailers.movies.infraestructure.persistence.mappers.MapperMovie;
import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaMovieImpl implements IMovieCRUDRepository {

    private final IJpaMovieRepository repo;
    private final MapperMovie mapper;

    JpaMovieImpl(IJpaMovieRepository repo, MapperMovie mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<Movie> findAll() {
        return repo.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public boolean findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return repo.findById(id).map(mapper::toModel);
    }

    @Override
    public Movie create(Movie movie) {
        MovieEntity newMovie = repo.save(mapper.toEntity(movie));

        return mapper.toModel(newMovie);
    }

    @Override
    public Movie update(Movie gender) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
