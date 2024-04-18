package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Director;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {
}
