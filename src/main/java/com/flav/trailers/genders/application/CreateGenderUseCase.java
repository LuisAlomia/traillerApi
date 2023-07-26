package com.flav.trailers.genders.application;

import com.flav.trailers.genders.domain.constants.GenderConstants;
import com.flav.trailers.genders.domain.exeptions.GenderResourceExist;
import com.flav.trailers.genders.domain.models.Gender;
import com.flav.trailers.genders.domain.repositories.IGenderCRUDRepository;
import org.springframework.http.HttpStatus;

public class CreateGenderUseCase {

    private final IGenderCRUDRepository repo;

    public CreateGenderUseCase(IGenderCRUDRepository repo) {
        this.repo = repo;
    }

    public Gender run(Gender gender) {
        boolean findGender = repo.findByName(gender.getName());

        if(findGender) {
            throw new GenderResourceExist(String.format(GenderConstants.GENDER_EXITS, gender.getName()), HttpStatus.FOUND);
        }

        return repo.create(gender);
    }

}
