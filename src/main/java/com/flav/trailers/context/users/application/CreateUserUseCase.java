package com.flav.trailers.context.users.application;


import com.flav.trailers.context.users.domain.constants.UserConstants;
import com.flav.trailers.context.users.domain.exceptions.UserResourceExist;
import com.flav.trailers.context.users.domain.models.User;
import com.flav.trailers.context.users.domain.repositories.IUserCRUDRepository;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class CreateUserUseCase {

    private final IUserCRUDRepository repo;

    public CreateUserUseCase(IUserCRUDRepository repo) {
        this.repo = repo;
    }

    public User run(User user) {
        boolean findUser = repo.findByEmail(user.getEmail());

        if(findUser) {
            throw new UserResourceExist(String.format(UserConstants.USER_EXITS, user.getEmail()), HttpStatus.FOUND);
        }

        return repo.create(user);
    }

}
