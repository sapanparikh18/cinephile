package co.incubyte;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
@MicronautTest
public class MovieControllerTest {
    @Inject
    @Client("/movies")
    HttpClient client;

    @Test
    @DisplayName("when searched for a movie it should return movie data")
    public void when_searched_for_a_movie_it_should_return_movie_data() {
        List<Movie> response = client.toBlocking().retrieve(HttpRequest.GET("?query=schindler"), Argument.listOf(Movie.class));
        assertThat(response.size()).isGreaterThan(0);
        assertThat(response.get(0).getImage().length()).isGreaterThan(0);
        assertThat(response.get(0).getName()).isEqualTo("Schindler's List");
        assertThat(response.get(0).getRating()).isGreaterThan(0);
        assertThat(response.get(0).getCount()).isGreaterThan(0);
        assertThat(response.get(0).getReleaseDate()).isEqualTo("1993-12-15");
    }

}
