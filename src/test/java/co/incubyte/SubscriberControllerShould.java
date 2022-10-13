package co.incubyte;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SubscriberControllerShould {
    @Mock
    RegistrationService registrationService;
    @Test
    @DisplayName("should invoice service save")
    public void should_invoice_service_save() {
        Subscriber subscriber = new Subscriber("sapanparikh18@gmail.com","sapan");
        CinephileController cinephileController = new CinephileController(registrationService);
        Subscriber savedSubscriber = cinephileController.save(subscriber);
        verify(registrationService).save(subscriber);
    }


}