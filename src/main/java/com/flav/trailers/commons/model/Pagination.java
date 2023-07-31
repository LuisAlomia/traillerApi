package com.flav.trailers.commons.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagination {

    private int size;
    private int page;
    private String orderBy;
    private String orderDir;

}
