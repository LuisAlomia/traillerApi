package com.flav.trailers.context.trailers.movies.infraestructure.persistence.mappers;

import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import com.flav.trailers.context.trailers.movies.infraestructure.persistence.entities.MovieEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperMovie {

    private final ModelMapper mapper;

    public MapperMovie(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Movie toModel(MovieEntity entity) { return mapper.map(entity, Movie.class); }
    public MovieEntity toEntity(Movie model) {
        return  mapper.map(model, MovieEntity.class);
    }

}
