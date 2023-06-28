package com.MovieRatingService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MovieRatingService.Model.LongestDurationResp;
import com.MovieRatingService.Model.Movie;
import com.MovieRatingService.Model.SubtotalResp;
import com.MovieRatingService.Model.TopRatedResp;
import com.MovieRatingService.Service.Service;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value="/api/v1")
public class Controller {
	
	@Autowired
	Service service;
	
	@GetMapping(value="/longest-duration-movies", produces= {"application/json"})
	@Operation(summary = "getLongestDurationMovies")
	 public ResponseEntity<List<LongestDurationResp>> getLongestDurationMovies() {
		List<LongestDurationResp> response = service.getLongestDuration();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value="/top-rated-movies", produces= {"application/json"})
	@Operation(summary = "getTopRatedMovies")
	 public ResponseEntity<List<TopRatedResp>> getTopRatedMovies() {
		List<TopRatedResp> topRatedResp=service.getTopRated();
		return new ResponseEntity<>(topRatedResp, HttpStatus.OK);
	}
	
	@PostMapping(value="/new-movie")
	@Operation(summary = "addNewMovie")
	 public ResponseEntity<String> addNewMovie(@RequestBody Movie movie) {
		service.addNewMovie(movie);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@PostMapping(value="/update-runtime-minutes", produces= {"application/json"})
	@Operation(summary = "updateRuntime")
	 public ResponseEntity<Object> updateRuntime() {
		service.updateRuntime();
		return new ResponseEntity<Object>("Success Time Updated", HttpStatus.OK);
	}
	
	@GetMapping(value="/genre-movies-with-subtotals", produces= {"application/json"})
	@Operation(summary = "getGenresWithSubtotals")
	 public ResponseEntity<List<SubtotalResp>> getGenresWithSubtotals() {
		List<SubtotalResp> response= service.getGenresWithSubtotals();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

}
