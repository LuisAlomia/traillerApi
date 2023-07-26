package com.flav.trailers.genders.infraestructure.config;

import com.flav.trailers.genders.application.CreateGenderUseCase;
import com.flav.trailers.genders.application.FindAllGenderUseCase;
import com.flav.trailers.genders.application.FindByIdGenderUseCase;
import com.flav.trailers.genders.domain.repositories.IGenderCRUDRepository;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

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
