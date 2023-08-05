package com.flav.trailers.context.trailers.movies.infrastructure.persistence.entities;

import com.flav.trailers.context.trailers.genders.infrastructure.persistence.entities.GenderEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;
    private String video;
    @Column(name = "release_date")
    private Date releaseDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Movie_Gender",
            joinColumns = @JoinColumn(name = "movie"),
            inverseJoinColumns = @JoinColumn(name = "gender")
    )
    private List<GenderEntity> gender = new ArrayList<>();

}
