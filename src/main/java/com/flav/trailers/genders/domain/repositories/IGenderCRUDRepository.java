package com.flav.trailers.genders.domain.repositories;

import com.flav.trailers.genders.domain.models.Gender;

import java.util.List;
import java.util.Optional;

public interface IGenderCRUDRepository {

    public List<Gender> findAll();
    public boolean findByName(String name);
    public Optional<Gender> findById(Long id);
    public Gender create(Gender gender);
    public Gender update(Gender gender);
    public boolean delete(Long id);

}
