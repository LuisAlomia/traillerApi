package com.flav.trailers.context.trailers.users.infrastructure.persistence.JPA;

import com.flav.trailers.context.trailers.users.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJpaUserRepository extends JpaRepository<UserEntity, Long> {

    public boolean existsByEmail(String email);

}
