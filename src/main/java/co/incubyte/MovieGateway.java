package co.incubyte;

import io.micronaut.context.annotation.Bean;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;

import java.util.List;

@Bean
public class MovieGateway {
    @Inject
    @Client("https://api.themoviedb.org/3/search")
    HttpClient client;

    public TmdbRespose find(String query) {
        return client
                .toBlocking()
                .retrieve(HttpRequest.GET("/movie?api_key=e470560acfb347655d8af373c29aba11&query=" + query), TmdbRespose.class);
    }
}
