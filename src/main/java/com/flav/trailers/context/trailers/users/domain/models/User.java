package com.flav.trailers.context.trailers.users.domain.models;

import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Movie> favorites = new ArrayList<>();
}
