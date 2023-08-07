package com.flav.trailers.context.trailers.users.application;

import com.flav.trailers.context.trailers.users.domain.models.User;
import com.flav.trailers.context.trailers.users.domain.repositories.IUserCRUDRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Log4j2
public class FindAllUserUseCase {

    private final IUserCRUDRepository repo;

    public FindAllUserUseCase(IUserCRUDRepository repo) {
        this.repo = repo;
    }

    @Cacheable("users")
    public List<User> run() {
        log.info("Successful request in class | FindAllUserUseCase |");
        return  repo.findAll();
    }

}
