package com.flav.trailers.context.trailers.users.infrastructure.controllers;

import com.flav.trailers.context.trailers.users.application.FindAllUserUseCase;
import com.flav.trailers.context.trailers.users.domain.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class FindAllUserController {

    private final FindAllUserUseCase useCase;

    public FindAllUserController(FindAllUserUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> data = useCase.run();

        return  ResponseEntity.status(HttpStatus.OK).body(data);
    }
}
