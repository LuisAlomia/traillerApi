package com.flav.trailers.context.trailers.genders.application;

import com.flav.trailers.context.trailers.genders.domain.constants.GenderConstants;
import com.flav.trailers.context.trailers.genders.domain.exeptions.GenderResourceNotFound;
import com.flav.trailers.context.trailers.genders.domain.models.Gender;
import com.flav.trailers.context.trailers.genders.domain.repositories.IGenderCRUDRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Log4j2
public class FindByIdGenderUseCase {

    private final IGenderCRUDRepository repo;

    public FindByIdGenderUseCase(IGenderCRUDRepository repo) {
        this.repo = repo;
    }

    @Cacheable("genders")
    public Gender run(Long id) {
        Optional<Gender> gender = repo.findById(id);

        if(gender.isEmpty()) {
            log.info("Request error in class | FindByIdGenderUseCase | gender not found");
            throw new GenderResourceNotFound(String.format(GenderConstants.GENDER_NOT_FOUND, id), HttpStatus.NOT_FOUND);
        }

        log.info("Successful request in class | FindByIdGenderUseCase |");
        return gender.get();
    }

}
