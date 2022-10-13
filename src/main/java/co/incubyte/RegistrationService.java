package co.incubyte;

import io.micronaut.context.annotation.Bean;
import jakarta.inject.Inject;

@Bean
public class RegistrationService {
    @Inject
    RegistrationRepo registrationRepo;
    public Subscriber save(Subscriber subscriber) {
        return registrationRepo.save(subscriber);
    }
}
