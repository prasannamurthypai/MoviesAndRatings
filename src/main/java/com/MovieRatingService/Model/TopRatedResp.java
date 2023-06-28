package com.MovieRatingService.Model;

public class TopRatedResp {
	private String tconst;
	 private String primaryTitle;
	 private Integer runtimeMinutes;
	 private Float averageRating;
	 
	 public String getTconst() {
			return tconst;
		}
		public void setTconst(String tconst) {
			this.tconst = tconst;
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
		public Float getAverageRating() {
			return averageRating;
		}
		public void setAverageRating(Float averageRating) {
			this.averageRating = averageRating;
		}
	 
	 
}
