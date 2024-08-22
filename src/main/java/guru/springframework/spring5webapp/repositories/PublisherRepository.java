package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.models.Publisher;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, UUID> {}
