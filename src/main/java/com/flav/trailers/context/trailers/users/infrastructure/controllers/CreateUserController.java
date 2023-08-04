package com.flav.trailers.context.trailers.users.infrastructure.controllers;

import com.flav.trailers.context.trailers.users.application.CreateUserUseCase;
import com.flav.trailers.context.trailers.users.domain.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class CreateUserController {

    private final CreateUserUseCase useCase;

    public CreateUserController(CreateUserUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User data = useCase.run((user));

        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
}
