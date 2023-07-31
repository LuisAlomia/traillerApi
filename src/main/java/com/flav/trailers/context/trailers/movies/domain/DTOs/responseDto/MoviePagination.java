package com.flav.trailers.context.trailers.movies.domain.DTOs.responseDto;

import com.flav.trailers.context.trailers.movies.domain.models.Movie;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MoviePagination {

    private int totalPages;
    private long totalItems;
    private int pageNo;
    private int pageSize;
    private boolean last;
    private List<Movie> data;

}
