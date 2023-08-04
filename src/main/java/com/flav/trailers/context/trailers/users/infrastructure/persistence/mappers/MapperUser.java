package com.flav.trailers.context.trailers.users.infrastructure.persistence.mappers;

import com.flav.trailers.context.trailers.genders.domain.models.Gender;
import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import com.flav.trailers.context.trailers.users.domain.models.User;
import com.flav.trailers.context.trailers.users.infrastructure.persistence.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperUser {

    private final ModelMapper mapper;

    public MapperUser(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public User toModel(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getFavorites().stream().map(movie -> new Movie(
                        movie.getId(),
                        movie.getName(),
                        movie.getDescription(),
                        movie.getImage(),
                        movie.getVideo(),
                        movie.getReleaseDate(),
                        movie.getGender().stream().map(item1 -> new Gender(
                                item1.getId(),
                                item1.getName())).toList())).toList());
    }

    public UserEntity toEntity(User model) {
        return  mapper.map(model, UserEntity.class);
    }

    public User toFavorite(UserEntity entity) {
        return mapper.map(entity, User.class);
    }

}
