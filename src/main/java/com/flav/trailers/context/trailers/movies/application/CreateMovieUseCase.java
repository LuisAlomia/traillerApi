package com.flav.trailers.context.trailers.movies.application;

import com.flav.trailers.context.trailers.genders.application.FindByIdGenderUseCase;
import com.flav.trailers.context.trailers.genders.domain.models.Gender;
import com.flav.trailers.context.trailers.movies.domain.DTOs.requestDto.MovieRequestDto;
import com.flav.trailers.context.trailers.movies.domain.exceptions.ErrorArgumentException;
import com.flav.trailers.context.trailers.movies.domain.exceptions.MovieResourceExist;
import com.flav.trailers.context.trailers.movies.domain.repositories.IMovieCRUDRepository;
import com.flav.trailers.context.trailers.movies.domain.constants.MovieConstants;
import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class CreateMovieUseCase {

    private final IMovieCRUDRepository repo;
    private final FindByIdGenderUseCase findGenderUseCase;

    public CreateMovieUseCase(IMovieCRUDRepository repo, FindByIdGenderUseCase findGenderUseCase) {
        this.repo = repo;
        this.findGenderUseCase = findGenderUseCase;
    }

    @CacheEvict(value = "movies", allEntries = true)
    public Movie run(MovieRequestDto movie) {
        //Check gender > 0
        if(movie.getGendersId().isEmpty()) {
            log.info("Request error in class | CreateMovieUseCase | gender not found");
            throw new ErrorArgumentException("the movie must belong to an existing genre", HttpStatus.BAD_REQUEST);
        }

        //Check name movie exits
        boolean findMovie = repo.findByName(movie.getName());

        if(findMovie) {
            log.info("Request error in class | CreateMovieUseCase | name movie exist");
            throw new MovieResourceExist(String.format(MovieConstants.MOVIE_EXITS, movie.getName()), HttpStatus.FOUND);
        }

        List<Gender> listGender = new ArrayList<>();

        //Check if the genre exists if it exists it adds it to the array if it does not throw an exception
        for (Long id: movie.getGendersId()) {
            Gender gender = findGenderUseCase.run(id);
            listGender.add(gender);
        }

        Movie newMovie = new Movie(movie.getName(),
                movie.getDescription(),
                movie.getImage(),
                movie.getVideo(),
                movie.getReleaseDate(),
                listGender);

        log.info("Successful request in class | CreateMovieUseCase |");
        return repo.create(newMovie);
    }

}
