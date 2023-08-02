package com.flav.trailers.context.trailers.genders.application;

import com.flav.trailers.context.trailers.genders.domain.models.Gender;
import com.flav.trailers.context.trailers.genders.domain.repositories.IGenderCRUDRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Log4j2
public class FindAllGenderUseCase {

    private final IGenderCRUDRepository repo;

    public FindAllGenderUseCase(IGenderCRUDRepository repo) {
        this.repo = repo;
    }

    @Cacheable("genders")
    public List<Gender> run() {
        log.info("Successful request in class | FindAllGenderUseCase |");
        return  repo.findAll();
    }

}
