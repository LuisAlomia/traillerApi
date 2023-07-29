package com.flav.trailers.context.users.application;


import com.flav.trailers.context.users.domain.models.User;
import com.flav.trailers.context.users.domain.repositories.IUserCRUDRepository;

import java.util.List;

public class FindAllUserUseCase {

    private final IUserCRUDRepository repo;

    public FindAllUserUseCase(IUserCRUDRepository repo) {
        this.repo = repo;
    }

    public List<User> run() {
        return  repo.findAll();
    }

}
