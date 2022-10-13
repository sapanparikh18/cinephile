package co.incubyte;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
@MicronautTest
public class RegisterControllerTest {
    @Inject
    @Client("/cinephile")
    HttpClient client;

    @Test
    @DisplayName("should register an email address")
    public void should_register_an_email_address() {
        Subscriber subscriber = new Subscriber("sapanparikh18@gmail.com","Sapan");
        Subscriber response = client.toBlocking().retrieve(HttpRequest.POST("/register", subscriber), Subscriber.class);
        assertThat(response.getId()).isGreaterThan(0);
        assertThat(response.getEmail()).isEqualTo("sapanparikh18@gmail.com");
        assertThat(response.getFirstName()).isEqualTo("Sapan");
    }

}
