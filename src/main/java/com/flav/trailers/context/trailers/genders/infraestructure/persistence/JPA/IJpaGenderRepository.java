package com.flav.trailers.context.trailers.genders.infraestructure.persistence.JPA;

import com.flav.trailers.context.trailers.genders.infraestructure.persistence.entities.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJpaGenderRepository extends JpaRepository<GenderEntity, Long> {

    public boolean existsByName(String name);

}
