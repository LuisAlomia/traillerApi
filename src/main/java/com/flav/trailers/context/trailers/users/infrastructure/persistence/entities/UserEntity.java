package com.flav.trailers.context.trailers.users.infrastructure.persistence.entities;

import com.flav.trailers.context.trailers.movies.infraestructure.persistence.entities.MovieEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "client")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "favorites",
            joinColumns = @JoinColumn(name = "client"),
            inverseJoinColumns = @JoinColumn(name = "movie")
    )
    private List<MovieEntity> favorites = new ArrayList<>();

}
