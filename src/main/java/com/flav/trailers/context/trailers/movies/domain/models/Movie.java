package com.flav.trailers.context.trailers.movies.domain.models;

import com.flav.trailers.context.trailers.genders.domain.models.Gender;
import com.flav.trailers.context.trailers.movies.valueObjects.StringTypeUrlVO;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@NoArgsConstructor
public class Movie {

    private Long id;
    private String name;
    private String description;
    private StringTypeUrlVO image;
    private StringTypeUrlVO video;
    private Date releaseDate;
    private List<Gender> gender;

    public Movie(Long id, String name, String description, String image, String video, Date releaseDate, List<Gender> gender) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = new StringTypeUrlVO(image);
        this.video = new StringTypeUrlVO(video);
        this.releaseDate = releaseDate;
        this.gender = gender;
    }

    public Movie(String name, String description, String image, String video, Date releaseDate, List<Gender> gender) {
        this.name = name;
        this.description = description;
        this.image = new StringTypeUrlVO(image);
        this.video = new StringTypeUrlVO(video);
        this.releaseDate = releaseDate;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image.getValue();
    }

    public String getVideo() {
        return video.getValue();
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public List<Gender> getGender() {
        return gender;
    }
}
