package com.flav.trailers.context.trailers.genders.application;

import com.flav.trailers.context.trailers.genders.domain.constants.GenderConstants;
import com.flav.trailers.context.trailers.genders.domain.exeptions.GenderResourceNotFound;
import com.flav.trailers.context.trailers.genders.domain.models.Gender;
import com.flav.trailers.context.trailers.genders.domain.repositories.IGenderCRUDRepository;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class FindByIdGenderUseCase {

    private final IGenderCRUDRepository repo;

    public FindByIdGenderUseCase(IGenderCRUDRepository repo) {
        this.repo = repo;
    }

    public Gender run(Long id) {
        Optional<Gender> gender = repo.findById(id);

        if(gender.isEmpty()) {
            throw new GenderResourceNotFound(String.format(GenderConstants.GENDER_NOT_FOUND, id), HttpStatus.NOT_FOUND);
        }

        return gender.get();
    }

}
