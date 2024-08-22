package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.models.Book;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, UUID> {}
