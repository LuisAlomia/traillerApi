package com.flav.trailers.context.trailers.movies.domain.models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    private Long id;
    private String name;
    private String description;
    private String image;
    private String video;
    private Date releaseDate;

}
