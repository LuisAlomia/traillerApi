package com.flav.trailers.context.trailers.users.infrastructure.persistence.JPA;

import com.flav.trailers.context.trailers.users.domain.models.User;
import com.flav.trailers.context.trailers.users.infrastructure.persistence.mappers.MapperUser;
import com.flav.trailers.context.trailers.users.domain.repositories.IUserCRUDRepository;
import com.flav.trailers.context.trailers.users.infrastructure.persistence.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaUserImpl implements IUserCRUDRepository {

    private final IJpaUserRepository repo;
    private final MapperUser mapper;

    JpaUserImpl(IJpaUserRepository repo, MapperUser mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<User> findAll() {
        return repo.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public boolean findByEmail(String email) {
        return repo.existsByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repo.findById(id).map(mapper::toModel);
    }

    @Override
    public Optional<User> findUserforfavorite(Long id) {
        return repo.findById(id).map(mapper::toFavorite);
    }

    @Override
    public User create(User user) {
        UserEntity newUser = repo.save(mapper.toEntity(user));

        return mapper.toModel(newUser);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
