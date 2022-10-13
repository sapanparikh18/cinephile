package co.incubyte;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/cinephile")
public class CinephileController {
    @Inject
    private RegistrationService registrationService;

    public CinephileController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Post("/register")
    public Subscriber save(@Body Subscriber subscriber) {
        return registrationService.save(subscriber);
    }
}