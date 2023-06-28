package com.MovieRatingService.Model;

import lombok.Data;

@Data
public class SubtotalResp {
	private String genres;
	private String primaryTitle;
	private Long numVotes;
	
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public String getPrimaryTitle() {
		return primaryTitle;
	}
	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}
	public Long getNumVotes() {
		return numVotes;
	}
	public void setNumVotes(Long numVotes) {
		this.numVotes = numVotes;
	}
	
	
	
}
