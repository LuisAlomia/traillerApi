package com.flav.trailers.context.trailers.movies.infrastructure.persistence.JPA;

import com.flav.trailers.commons.model.Pagination;
import com.flav.trailers.context.trailers.movies.domain.DTOs.responseDto.MoviePagination;
import com.flav.trailers.context.trailers.movies.domain.repositories.IMovieCRUDRepository;
import com.flav.trailers.context.trailers.movies.infrastructure.persistence.entities.MovieEntity;
import com.flav.trailers.context.trailers.movies.infrastructure.persistence.mappers.MapperMovie;
import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public MoviePagination findAll(Pagination pagination) {
        //sort pages by direction and property
        Sort sort = pagination.getOrderDir().equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(pagination.getOrderBy()).ascending()
                : Sort.by(pagination.getOrderBy()).descending();

        //pagination parameters
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getSize(), sort);

        //movies paginated according to parameters
        Page<MovieEntity> pagesMovies = repo.findAll(pageable);

        //movie page to list
        List<Movie> listMovies = pagesMovies.stream().map(mapper::toModel).toList();

        //return of mapper of List Movie to MoviePagination
        return MoviePagination.builder()
                .totalPages(pagesMovies.getTotalPages())
                .totalItems(pagesMovies.getTotalElements())
                .pageNo(pagesMovies.getNumber() + 1)
                .pageSize(pagesMovies.getSize())
                .last(pagesMovies.isLast())
                .data(listMovies)
                .build();
    }

    @Override
    public boolean findByName(String name) {
        return repo.existsByName(name);
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
