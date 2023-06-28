package com.MovieRatingService.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "movie")
public class MovieEntity {
	@Id
	@Column(name = "tconst")
	private String tconst;
	@Column(name = "title_type")
	private String titleType;
	@Column(name = "primary_title")
	private String primaryTitle;
	@Column(name = "runtime_minutes")
	private Integer runtimeMinutes;
	@OneToOne(mappedBy = "movie")
	@PrimaryKeyJoinColumn
	private RatingEntity rating;
	@Column(name = "genres")
	private String genres;
	public String getTconst() {
		return tconst;
	}
	public void setTconst(String tconst) {
		this.tconst = tconst;
	}
	public String getTitleType() {
		return titleType;
	}
	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}
	public String getPrimaryTitle() {
		return primaryTitle;
	}
	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}
	public Integer getRuntimeMinutes() {
		return runtimeMinutes;
	}
	public void setRuntimeMinutes(Integer runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}

	public RatingEntity getRating() {
		return rating;
	}

	public void setRating(RatingEntity rating) {
		this.rating = rating;
	}
}
