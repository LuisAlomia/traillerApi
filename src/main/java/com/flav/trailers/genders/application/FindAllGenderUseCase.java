package com.flav.trailers.genders.application;

import com.flav.trailers.genders.domain.models.Gender;
import com.flav.trailers.genders.domain.repositories.IGenderCRUDRepository;

import java.util.List;

public class FindAllGenderUseCase {

    private final IGenderCRUDRepository repo;

    public FindAllGenderUseCase(IGenderCRUDRepository repo) {
        this.repo = repo;
    }

    public List<Gender> run() {
        return  repo.findAll();
    }

}
