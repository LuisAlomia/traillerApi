package com.flav.trailers.context.trailers.movies.domain.DTOs.requestDto;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieRequestDto {
    private Long id;
    private String name;
    private String description;
    private String image;
    private String video;
    private Date releaseDate;
    private List<Long> gendersId = new ArrayList<>();
}
