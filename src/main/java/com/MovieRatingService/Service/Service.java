package com.MovieRatingService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.MovieRatingService.Model.LongestDurationResp;
import com.MovieRatingService.Model.Movie;
import com.MovieRatingService.Model.SubtotalResp;
import com.MovieRatingService.Model.TopRatedResp;
import com.MovieRatingService.entity.MovieEntity;
import com.MovieRatingService.repository.MovieRepository;

import jakarta.transaction.Transactional;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	private MovieRepository movieRepository;
	
	//Get Movies with Longest Duration
	public List<LongestDurationResp> getLongestDuration() {

		List<MovieEntity> moviesList = movieRepository.findLongestRuntime();
		return moviesList.stream().map(movie -> {
			LongestDurationResp response = new LongestDurationResp();
			response.setGenres(movie.getGenres());
			response.setPrimaryTitle(movie.getPrimaryTitle());
			response.setTconst(movie.getTconst());
			response.setRuntimeMinutes(movie.getRuntimeMinutes());
			return response;
		}).toList();
	}
	
	//Get Top Rated Movies
	public List<TopRatedResp> getTopRated() {
		List<MovieEntity> topRatedMoviesList = movieRepository.findByRatingAverageRatingIsGreaterThanOrderByRatingAverageRatingDesc(6.0);
		return topRatedMoviesList.stream().map(movie -> {
			TopRatedResp topRatedResp = new TopRatedResp();
			topRatedResp.setAverageRating(movie.getRating().getAverageRating());
			topRatedResp.setTconst(movie.getTconst());
			topRatedResp.setPrimaryTitle(movie.getPrimaryTitle());
			topRatedResp.setRuntimeMinutes(movie.getRuntimeMinutes());
			return topRatedResp;
		}).toList();
	}
	
	//Add New Movie in DB
	@Transactional
	public void addNewMovie(Movie movie){
		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setGenres(movie.getGenres());
		movieEntity.setTconst(movie.getTconst());
		movieEntity.setPrimaryTitle(movie.getPrimaryTitle());
		movieEntity.setRuntimeMinutes(movie.getRuntimeMinutes());
		movieEntity.setTitleType(movie.getTitleType());
		movieRepository.save(movieEntity);
	}
	
	//Update Runtime
	@Transactional
	public void updateRuntime() {
		movieRepository.updateRuntimeMinutes();
		}
	
	// Get genre wise primary title and numvotes with sub total
	public List<SubtotalResp> getGenresWithSubtotals() {
		List<MovieEntity> numVotesSubtotalList = movieRepository.findGenreWiseVotesWithSubtotal();
		return numVotesSubtotalList.stream().map( movie ->{
			SubtotalResp response = new SubtotalResp();
			response.setGenres(movie.getGenres());
			if(movie.getPrimaryTitle().equalsIgnoreCase("TOTAL")) {
				response.setGenres("");
			}
			else {
				response.setPrimaryTitle(movie.getPrimaryTitle());
			}
			response.setNumVotes(movie.getRating().getNumVotes());
			return response;
		}).toList();
	}
}
