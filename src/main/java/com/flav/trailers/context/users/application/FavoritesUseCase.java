package com.flav.trailers.context.users.application;

import com.flav.trailers.context.trailers.movies.application.FindByIdMovieUseCase;
import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import com.flav.trailers.context.users.domain.models.User;
import com.flav.trailers.context.users.domain.repositories.IUserCRUDRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;

import java.util.Objects;

@Log4j2
public class FavoritesUseCase {

    private final IUserCRUDRepository repo;
    private final FindByIdUserUseCase userFindById;
    private final FindByIdMovieUseCase movieFindById;

    public FavoritesUseCase(IUserCRUDRepository repo, FindByIdUserUseCase userFindById, FindByIdMovieUseCase movieFindById) {
        this.repo = repo;
        this.userFindById = userFindById;
        this.movieFindById = movieFindById;
    }

    @CacheEvict(value = "users", allEntries = true)
    public boolean run(Long idUser, Long idMovie) {
        //we look for the user if it is not found we return error
        User user = userFindById.run(idUser);

        //we look for the movie if it is not found we return error
        Movie movie = movieFindById.run(idMovie);

        //check if the movie is already added
        Movie movieExist = user.getFavorites()
                .stream()
                .filter(movie1 -> Objects.equals(movie1.getId(), idMovie))
                .findAny()
                .orElse(null);

        //if it is already added we delete it and return false
        if(movieExist != null) {
            user.getFavorites().removeIf(movie1 -> movie1.getId().equals(idMovie));
            repo.create(user);

            return false;
        }

        //if it is not added we add it and return true
        user.getFavorites().add(movie);
        repo.create(user);

        log.info("Successful request in class | FavoritesUseCase |");
        return true;
    }

}
