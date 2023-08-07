package com.flav.trailers.context.trailers.users.infrastructure.persistence.JPA;

import com.flav.trailers.context.trailers.movies.infrastructure.persistence.entities.MovieEntity;
import com.flav.trailers.context.trailers.users.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IJpaUserRepository extends JpaRepository<UserEntity, Long> {

    public boolean existsByEmail(String email);

    @EntityGraph(attributePaths = "favorites")
    public List<UserEntity> findAll();

    @EntityGraph(attributePaths = "favorites")
    public Optional<UserEntity> findById(Long id);
}
