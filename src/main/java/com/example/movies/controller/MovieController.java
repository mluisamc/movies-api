package com.example.movies.controller;

import com.example.movies.client.MovieWebClient;
import com.example.movies.model.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {

    @Autowired
    private MovieWebClient movieWebClient;


    @GetMapping(path = "")
    public Mono<Results> getMoviesByNameAndPage(@RequestParam String name, @RequestParam(required = false) Integer page) {
        return movieWebClient.getMoviesByNameAndPage(name, page);

    }
}
