package com.flav.trailers.genders.infraestructure.persistence.mappers;

import com.flav.trailers.genders.domain.models.Gender;
import com.flav.trailers.genders.infraestructure.persistence.entities.GenderEntity;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperGender {

    private final ModelMapper mapper;

    public MapperGender(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Gender toModel(GenderEntity entity) { return mapper.map(entity, Gender.class); }
    public GenderEntity toEntity(Gender model) {
        return  mapper.map(model, GenderEntity.class);
    }

}
