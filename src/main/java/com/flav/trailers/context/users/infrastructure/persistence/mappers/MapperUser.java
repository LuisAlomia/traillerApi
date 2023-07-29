package com.flav.trailers.context.users.infrastructure.persistence.mappers;

import com.flav.trailers.context.users.domain.models.User;
import com.flav.trailers.context.users.infrastructure.persistence.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperUser {

    private final ModelMapper mapper;

    public MapperUser(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public User toModel(UserEntity entity) { return mapper.map(entity, User.class); }
    public UserEntity toEntity(User model) {
        return  mapper.map(model, UserEntity.class);
    }

}
