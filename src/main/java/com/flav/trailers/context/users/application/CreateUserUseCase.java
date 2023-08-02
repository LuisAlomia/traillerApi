package com.flav.trailers.context.users.application;


import com.flav.trailers.context.users.domain.constants.UserConstants;
import com.flav.trailers.context.users.domain.exceptions.UserResourceExist;
import com.flav.trailers.context.users.domain.models.User;
import com.flav.trailers.context.users.domain.repositories.IUserCRUDRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;

@Log4j2
public class CreateUserUseCase {

    private final IUserCRUDRepository repo;

    public CreateUserUseCase(IUserCRUDRepository repo) {
        this.repo = repo;
    }

    @CacheEvict(value = "users", allEntries = true)
    public User run(User user) {
        boolean findUser = repo.findByEmail(user.getEmail());

        if(findUser) {
            log.info("Request error in class | CreateUserUseCase | user exist");
            throw new UserResourceExist(String.format(UserConstants.USER_EXITS, user.getEmail()), HttpStatus.FOUND);
        }

        log.info("Successful request in class | CreateUserUseCase |");
        return repo.create(user);
    }

}
