package com.flav.trailers.context.trailers.movies.infrastructure.persistence.JPA;

import com.flav.trailers.context.trailers.movies.infrastructure.persistence.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJpaMovieRepository extends JpaRepository<MovieEntity, Long> {

    public boolean existsByName(String name);

}
