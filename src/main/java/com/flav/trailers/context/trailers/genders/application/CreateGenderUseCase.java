package com.flav.trailers.context.trailers.genders.application;

import com.flav.trailers.context.trailers.genders.domain.constants.GenderConstants;
import com.flav.trailers.context.trailers.genders.domain.exeptions.GenderResourceExist;
import com.flav.trailers.context.trailers.genders.domain.models.Gender;
import com.flav.trailers.context.trailers.genders.domain.repositories.IGenderCRUDRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;

@Log4j2
public class CreateGenderUseCase {

    private final IGenderCRUDRepository repo;

    public CreateGenderUseCase(IGenderCRUDRepository repo) {
        this.repo = repo;
    }

    @CacheEvict(value = "genders", allEntries = true)
    public Gender run(Gender gender) {
        boolean findGender = repo.findByName(gender.getName());

        if(findGender) {
            log.info("Request error in class | CreateGenderUseCase | gender exist");
            throw new GenderResourceExist(String.format(GenderConstants.GENDER_EXITS, gender.getName()), HttpStatus.FOUND);
        }

        log.info("Successful request in class | CreateGenderUseCase |");
        return repo.create(gender);
    }

}
