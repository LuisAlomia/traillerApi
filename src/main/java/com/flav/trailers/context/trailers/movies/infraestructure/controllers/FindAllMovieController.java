package com.flav.trailers.context.trailers.movies.infraestructure.controllers;

import com.flav.trailers.commons.constants.PaginationConstants;
import com.flav.trailers.commons.model.Pagination;
import com.flav.trailers.context.trailers.movies.application.FindAllMovieUseCase;
import com.flav.trailers.context.trailers.movies.domain.DTOs.responseDto.MoviePagination;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class FindAllMovieController {

    private final FindAllMovieUseCase useCase;

    public FindAllMovieController(FindAllMovieUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public ResponseEntity<MoviePagination> findAll(
            @RequestParam(name = "pageNo", defaultValue = PaginationConstants.PAGE, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = PaginationConstants.SIZE, required = false) int pageSize,
            @RequestParam(name = "orderBy", defaultValue = PaginationConstants.ORDER_BY, required = false) String orderBy,
            @RequestParam(name = "orderDir", defaultValue = PaginationConstants.ORDER_DIR, required = false) String orderDir) {

        MoviePagination data = useCase.run(Pagination.builder()
                .size(pageSize)
                .page(pageNo)
                .orderBy(orderBy.toLowerCase())
                .orderDir(orderDir.toUpperCase())
                .build());



        return  ResponseEntity.status(HttpStatus.OK).body(data);
    }
}


