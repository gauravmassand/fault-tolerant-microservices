package com.example.userapplication.UserApplication.service;


import com.example.userapplication.UserApplication.dto.Movie;
import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static List<Movie> userRecommendationMovie = new ArrayList<>();
    static{
        Movie batmanBegins = new Movie("Batman Begins","Action");
        Movie avengers = new Movie("Avengers","Action");
        Movie ironMan = new Movie("Iron Man","Action");
        Movie harryPotter = new Movie("Harry Potter","Fiction");
        Movie lordOfTheRings = new Movie("Lord of the Rings","Fiction");
        Movie twilight = new Movie("Twilight","Romance");
        Movie sherlock = new Movie("Sherlock Holmes","Fiction");
        userRecommendationMovie.add(batmanBegins);
        userRecommendationMovie.add(avengers);
        userRecommendationMovie.add(ironMan);
        userRecommendationMovie.add(harryPotter);
        userRecommendationMovie.add(lordOfTheRings);
        userRecommendationMovie.add(twilight);
        userRecommendationMovie.add(sherlock);
    }

    @Autowired
    RestTemplate restTemplate;

   @HystrixCommand(fallbackMethod = "callMovieDetailsFallBack")
    public String getMovieDetails() {
        String responseReceived = restTemplate
                .exchange("http://localhost:8081/getUserMovieDetails"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }).getBody();

        return responseReceived;
    }

    public String callMovieDetailsFallBack() {
       System.out.println("User Recommendation Service is down returning general recommendation movies");
        Gson gson = new Gson();
        return gson.toJson(getAllMovieList());

    }

    public List<Movie> getAllMovieList() {
        return userRecommendationMovie;
    }


}
