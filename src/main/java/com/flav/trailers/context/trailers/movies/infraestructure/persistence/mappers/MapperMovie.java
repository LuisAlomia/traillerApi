package com.flav.trailers.context.trailers.movies.infraestructure.persistence.mappers;

import com.flav.trailers.context.trailers.genders.domain.models.Gender;
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

    public Movie toModel(MovieEntity entity) {
       return new Movie(
               entity.getId(),
               entity.getName(),
               entity.getDescription(),
               entity.getImage(),
               entity.getVideo(),
               entity.getReleaseDate(),
               entity.getGender().stream().map(item -> new Gender(item.getId(), item.getName())).toList()
        );
    }
    public MovieEntity toEntity(Movie model) {
        return  mapper.map(model, MovieEntity.class);
    }

}
