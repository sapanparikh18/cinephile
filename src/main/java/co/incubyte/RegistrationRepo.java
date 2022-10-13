package co.incubyte;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
interface RegistrationRepo extends CrudRepository<Subscriber, Long> {
}
