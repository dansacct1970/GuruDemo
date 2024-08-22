package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.models.Author;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, UUID> {}
