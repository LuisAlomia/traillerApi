package com.flav.trailers.context.users.application;


import com.flav.trailers.context.users.domain.constants.UserConstants;
import com.flav.trailers.context.users.domain.exceptions.UserResourceNotFound;
import com.flav.trailers.context.users.domain.models.User;
import com.flav.trailers.context.users.domain.repositories.IUserCRUDRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Log4j2
public class FindByIdUserUseCase {

    private final IUserCRUDRepository repo;

    public FindByIdUserUseCase(IUserCRUDRepository repo) {
        this.repo = repo;
    }

    public User run(Long id) {
        Optional<User> user = repo.findById(id);

        if(user.isEmpty()) {
            log.info("Request error in class | FindAllUserUseCase | user not found");
            throw new UserResourceNotFound(String.format(UserConstants.USER_NOT_FOUND, id), HttpStatus.NOT_FOUND);
        }

        log.info("Successful request in class | FindAllUserUseCase |");
        return user.get();
    }

}
