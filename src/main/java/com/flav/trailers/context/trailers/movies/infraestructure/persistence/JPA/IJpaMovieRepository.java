package com.flav.trailers.context.trailers.movies.infraestructure.persistence.JPA;

import com.flav.trailers.context.trailers.movies.infraestructure.persistence.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJpaMovieRepository extends JpaRepository<MovieEntity, Long> {

    public boolean findByName(String name);

}
