package com.MovieRatingService.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Movie {
	private String tconst;
	private String titleType;
	private String primaryTitle;
	private Integer runtimeMinutes;
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
	
	
}
