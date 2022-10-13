package co.incubyte;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
public class MovieControllerShould {
    @Mock
    MovieService movieService;

    @Test
    @DisplayName("should invoke search method on the service")
    public void should_invoke_search_method_on_the_service() {
        MovieController movieController = new MovieController(movieService);
        List<Movie> movies = movieController.find("Schindler");
        verify(movieService).find("Schindler");
    }

}
