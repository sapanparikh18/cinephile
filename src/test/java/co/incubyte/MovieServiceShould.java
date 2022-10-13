package co.incubyte;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class MovieServiceShould {

    @Mock
    MovieGateway movieGateway;

    @Test
    @DisplayName("find should invoke gateway find")
    public void find_should_invoke_gateway_find() {
        MovieService movieService = new MovieService(movieGateway);

        List<Movie> moviesData = Lists.list(new Movie("/sF1U4EUQS8YHUYjNl3pMGNIQyr0.jps", "Schindler's List", 70000, "1993-01-01", 7.6f));
        TmdbRespose response = new TmdbRespose(1,moviesData);
        when(movieGateway.find("Schindler")).thenReturn(response);

        List<Movie> movies = movieService.find("Schindler");
        verify(movieGateway).find("Schindler");
        Assertions.assertThat(movies.get(0).getName()).isEqualTo("Schindler's List");
        Assertions.assertThat(movies.get(0).getImage()).isEqualTo("/sF1U4EUQS8YHUYjNl3pMGNIQyr0.jps");
        Assertions.assertThat(movies.get(0).getRating()).isEqualTo(7.6f);
        Assertions.assertThat(movies.get(0).getCount()).isEqualTo(70000);
        Assertions.assertThat(movies.get(0).getReleaseDate()).isEqualTo("1993-01-01");
    }


}