package com.flav.trailers.context.trailers.genders.infrastructure.config;

import com.flav.trailers.context.trailers.genders.application.CreateGenderUseCase;
import com.flav.trailers.context.trailers.genders.application.FindAllGenderUseCase;
import com.flav.trailers.context.trailers.genders.application.FindByIdGenderUseCase;
import com.flav.trailers.context.trailers.genders.domain.repositories.IGenderCRUDRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenderApplicationConfig {

    @Bean
    public FindAllGenderUseCase findAllGenderUseCase(IGenderCRUDRepository repo) {
        return new FindAllGenderUseCase(repo);
    }

    @Bean
    public FindByIdGenderUseCase findByIdGenderUseCase(IGenderCRUDRepository repo) {
        return new FindByIdGenderUseCase(repo);
    }

    @Bean
    public CreateGenderUseCase createGenderUseCase(IGenderCRUDRepository repo) {
        return new CreateGenderUseCase(repo);
    }

}
