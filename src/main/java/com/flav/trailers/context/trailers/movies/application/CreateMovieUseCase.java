package com.flav.trailers.context.trailers.movies.application;

import com.flav.trailers.context.trailers.genders.application.FindByIdGenderUseCase;
import com.flav.trailers.context.trailers.genders.domain.models.Gender;
import com.flav.trailers.context.trailers.movies.domain.DTOs.requestDto.MovieRequestDto;
import com.flav.trailers.context.trailers.movies.domain.exceptions.MovieResourceExist;
import com.flav.trailers.context.trailers.movies.domain.repositories.IMovieCRUDRepository;
import com.flav.trailers.context.trailers.movies.domain.constants.MovieConstants;
import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class CreateMovieUseCase {

    private final IMovieCRUDRepository repo;
    private final FindByIdGenderUseCase findGenderUseCase;

    public CreateMovieUseCase(IMovieCRUDRepository repo, FindByIdGenderUseCase findGenderUseCase) {
        this.repo = repo;
        this.findGenderUseCase = findGenderUseCase;
    }

    public Movie run(MovieRequestDto movie) {
        boolean findMovie = repo.findByName(movie.getName());

        if(findMovie) {
            throw new MovieResourceExist(String.format(MovieConstants.MOVIE_EXITS, movie.getName()), HttpStatus.FOUND);
        }

        List<Gender> listGender = new ArrayList<>();

        //Check if the genre exists if it exists it adds it to the array if it does not throw an exception
        for (Long id: movie.getGendersId()) {
            Gender gender = findGenderUseCase.run(id);
            listGender.add(gender);
        }

        Movie newMovie = Movie.builder()
                .name(movie.getName())
                .description(movie.getDescription())
                .image(movie.getImage())
                .video(movie.getVideo())
                .releaseDate(movie.getReleaseDate())
                .gender(listGender)
                .build();

        return repo.create(newMovie);
    }

}
