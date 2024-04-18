package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
