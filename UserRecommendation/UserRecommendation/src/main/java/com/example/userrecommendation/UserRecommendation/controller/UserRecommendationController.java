package com.example.userrecommendation.UserRecommendation.controller;

import com.example.userrecommendation.UserRecommendation.dto.Movie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRecommendationController {

    private static List<Movie> userRecommendationMovie = new ArrayList<>();

    static {
        Movie batmanBegins = new Movie("Batman Begins","Action");
        Movie ironMan = new Movie("Iron Man","Action");
        Movie harryPotter = new Movie("Harry Potter","Fiction");
        Movie lordOfTheRings = new Movie("Lord of the Rings","Fiction");
        Movie twilight = new Movie("Twilight","Romance");
        userRecommendationMovie.add(batmanBegins);
        userRecommendationMovie.add(ironMan);
        userRecommendationMovie.add(harryPotter);
        userRecommendationMovie.add(lordOfTheRings);
        userRecommendationMovie.add(twilight);
    }


    @RequestMapping(value = "/getUserMovieDetails",method = RequestMethod.GET)
    public List<Movie> getUserRecommendationMovies() {
        return userRecommendationMovie;
    }
}
