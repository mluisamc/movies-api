package com.example.movies;

import com.example.movies.client.MovieWebClient;
import com.example.movies.model.Movie;
import com.example.movies.model.Results;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;

@DirtiesContext(classMode = BEFORE_CLASS)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = MoviesApplication.class)
public class MovieControllerTest {
    @Autowired
    private WebTestClient testClient;

    @MockBean
    private MovieWebClient movieWebClient;

    @Test
    void whenMovieEndpointIsCalled_thenIsOK() {
        Movie movie = new Movie(
                1,
                "en",
                "Guardians of the Galaxy Vol. 3",
                "Peter Quill, still reeling from the loss of Gamora",
                5,
                "poster_path",
                "release_date",
                "title",
                true,
                5,
                5);
        Results results = new Results(1, new Movie[]{movie}, 1, 1);
        Mockito.when(movieWebClient.getMoviesByNameAndPage(Mockito.anyString(), Mockito.anyInt())).thenReturn(Mono.just(results));

        testClient.get()
                .uri("/movies?name=guardian")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Results.class);
    }


}