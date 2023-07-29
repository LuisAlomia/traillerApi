package com.flav.trailers.context.users.infrastructure.controllers;

import com.flav.trailers.context.users.application.FindByIdUserUseCase;
import com.flav.trailers.context.users.domain.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class FindByIdUserController {

    private final FindByIdUserUseCase useCase;

    public FindByIdUserController(FindByIdUserUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findOne(@PathVariable("id") Long id) {
        User data = useCase.run(id);

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
}
