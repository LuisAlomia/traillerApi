package com.flav.trailers.context.users.infrastructure.controllers;

import com.flav.trailers.context.users.application.FavoritesUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/favorites")
public class FavoritesController {

    private final FavoritesUseCase useCase;

    public FavoritesController(FavoritesUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/user/{idUser}/movie/{idMovie}")
    public ResponseEntity<Boolean> run(@PathVariable("idUser") Long idUser, @PathVariable("idMovie") Long idMovie) {
        boolean data = useCase.run(idUser, idMovie);

        return ResponseEntity.status(HttpStatus.CREATED).body(data) ;
    }

}
