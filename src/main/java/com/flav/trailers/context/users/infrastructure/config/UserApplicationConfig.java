package com.flav.trailers.context.users.infrastructure.config;

import com.flav.trailers.context.trailers.movies.application.FindByIdMovieUseCase;
import com.flav.trailers.context.users.application.CreateUserUseCase;
import com.flav.trailers.context.users.application.FavoritesUseCase;
import com.flav.trailers.context.users.application.FindAllUserUseCase;
import com.flav.trailers.context.users.application.FindByIdUserUseCase;
import com.flav.trailers.context.users.domain.repositories.IUserCRUDRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserApplicationConfig {

    @Bean
    public FindAllUserUseCase findAllUserUseCase(IUserCRUDRepository repo) {
        return new FindAllUserUseCase(repo);
    }

    @Bean
    public FindByIdUserUseCase findByIdUserUseCase(IUserCRUDRepository repo) {
        return new FindByIdUserUseCase(repo);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(IUserCRUDRepository repo) {return new CreateUserUseCase(repo); }

    @Bean
    public FavoritesUseCase favoritesUseCase(IUserCRUDRepository repo, FindByIdMovieUseCase movieFindById) {
        return new FavoritesUseCase(repo, movieFindById);
    }

}
