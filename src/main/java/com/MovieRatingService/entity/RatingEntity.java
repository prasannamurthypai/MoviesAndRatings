package com.MovieRatingService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "rating")
public class RatingEntity {
    @Id
    @Column(name = "tconst")
    private String ratingId;
    @OneToOne
    @MapsId
    @JoinColumn(name = "tconst")
    @JsonIgnore
    private MovieEntity movie;
    @Column(name = "average_rating")
    private Float averageRating;
    @Column(name = "num_votes")
    private Long numVotes;

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    public Float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Float averageRating) {
        this.averageRating = averageRating;
    }

    public Long getNumVotes() {
        return numVotes;
    }

    public void setNumVotes(Long numVotes) {
        this.numVotes = numVotes;
    }
}
