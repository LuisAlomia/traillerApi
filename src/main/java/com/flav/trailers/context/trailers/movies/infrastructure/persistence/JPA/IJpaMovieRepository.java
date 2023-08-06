package com.flav.trailers.context.trailers.movies.infrastructure.persistence.JPA;

import com.flav.trailers.context.trailers.movies.infrastructure.persistence.entities.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IJpaMovieRepository extends JpaRepository<MovieEntity, Long> {

    public boolean existsByName(String name);

    @EntityGraph(attributePaths = "gender")
    public Page<MovieEntity> findAll(Pageable pageable);

    @EntityGraph(attributePaths = "gender")
    public Optional<MovieEntity> findById(Long id);

}
