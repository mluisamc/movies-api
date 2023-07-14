package com.example.movies.client;

import com.example.movies.model.Results;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Optional;

@Component
public class MovieWebClient {
    private final WebClient webClient;

    @Value("${movies.include_adult}")
    private boolean includeAdult;
    @Value("${movies.language}")
    private String language;

    @Value("${movies.token}")
    private String token;

    public MovieWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.themoviedb.org/3").build();
    }

    public Mono<Results> getMoviesByNameAndPage(String name, Integer page) {
        return this.webClient.get().uri(builder -> builder.path("/search/movie")
                        .queryParam("query", name)
                        .queryParam("include_adult", includeAdult)
                        .queryParam("language", language)
                        .queryParamIfPresent("page", Optional.ofNullable(page))
                        .build())
                .header("accept", "application/json")
                .header("Authorization", String.format("Bearer %s", token))
                .retrieve().bodyToMono(Results.class);
    }
}
