package com.MovieRatingService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MovieRatingService.entity.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, String>{
    @Query(value = "Select * \r\n"
            + "from movie ORDER BY runtime_minutes DESC\r\n"
            + "LIMIT 10", nativeQuery = true)
    List<MovieEntity> findLongestRuntime();

    List<MovieEntity> findByRatingAverageRatingIsGreaterThanOrderByRatingAverageRatingDesc(Double averageRating);
    
    @Modifying
    @Query(value="UPDATE movie\r\n"
			+ "SET runtime_minutes = \r\n"
			+ "CASE \r\n"
			+ "WHEN genres = 'Documentary' THEN runtime_minutes + 15\r\n"
			+ "WHEN genres = 'Animation' THEN runtime_minutes + 30\r\n"
			+ "ELSE runtime_minutes + 45\r\n"
			+ "END;",nativeQuery = true)
    void updateRuntimeMinutes();
    
    @Query(value="SELECT  m.genres as genre,coalesce(m.primary_title,'TOTAL')as primaryTitle, SUM(num_votes) AS numVotes\r\n"
    		+ "FROM movie m\r\n"
    		+ "JOIN rating r ON m.tconst = r.tconst\r\n"
    		+ "GROUP BY m.genres, m.primary_title with rollup;", nativeQuery = true)
    List<MovieEntity> findGenreWiseVotesWithSubtotal();
}
