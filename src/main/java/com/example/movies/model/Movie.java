package com.example.movies.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Movie(
        int id,
        String original_language,
        String original_title,
        String overview,
        double popularity,
        String poster_path,
        String release_date,
        String title,
        boolean video,
        double vote_average,
        int vote_count) {
}
