package com.example.movies.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Results(
        int page,
        Movie[] results,
        int total_pages,
        int total_results) {
}