package com.flav.trailers.genders.infraestructure.persistence.JPA;

import com.flav.trailers.genders.domain.models.Gender;
import com.flav.trailers.genders.domain.repositories.IGenderCRUDRepository;
import com.flav.trailers.genders.infraestructure.persistence.entities.GenderEntity;
import com.flav.trailers.genders.infraestructure.persistence.mappers.MapperGender;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaGenderImpl implements IGenderCRUDRepository {

    private final IJpaGenderRepository repo;
    private final MapperGender mapper;

    JpaGenderImpl(IJpaGenderRepository repo, MapperGender mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<Gender> findAll() {
        return repo.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public boolean findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public Optional<Gender> findById(Long id) {
        return repo.findById(id).map(mapper::toModel);
    }

    @Override
    public Gender create(Gender gender) {
        GenderEntity newGender = repo.save(mapper.toEntity(gender));

        return mapper.toModel(newGender);
    }

    @Override
    public Gender update(Gender gender) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
