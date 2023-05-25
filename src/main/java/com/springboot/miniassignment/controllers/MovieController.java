package com.springboot.miniassignment.controllers;

import com.springboot.miniassignment.models.Movie;
import com.springboot.miniassignment.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")


public class MovieController {
    private static Logger logger = LoggerFactory.getLogger(MovieService.class);
    @Autowired
    private MovieService movieService;
    @GetMapping
    public List<Movie> findAll(){
        logger.info("findAll books " + this.getClass().getName());
        return movieService.findAll();
    }


    @PostMapping("/importCsv")
    public List<Movie> importCsv(){
        return movieService.readCsv();
    }
    @PostMapping
    public Movie save(@RequestBody Movie movie) {
        logger.info("save book " + this.getClass().getName());
        return movieService.save(movie);
    }
    @GetMapping("/director/{director}/year-range/{startYear}/{endYear}")
    public List<String> getMoviesByDirectorAndYearRange(@PathVariable String director,
                                                        @PathVariable int startYear,
                                                        @PathVariable int endYear) {
        return movieService.getDirector(director, startYear, endYear);
    }
    @GetMapping("/englishTitles")
    public List<String> getEnglishTitlesWithUserReviewsGreaterThan(
            @RequestParam int userReviewFilter) {
        return movieService.getEnglishTitlesWithUserReviewsGreaterThan(userReviewFilter);
    }
}

