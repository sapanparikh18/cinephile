package co.incubyte;

import io.micronaut.context.annotation.Bean;

import java.util.List;

@Bean
public class MovieService {
    private MovieGateway movieGateway;

    public MovieService(MovieGateway movieGateway) {
        this.movieGateway = movieGateway;
    }

    public List<Movie> find(String query) {
        TmdbRespose tmdbRespose = movieGateway.find(query);
        return tmdbRespose.getResults();
    }
}
