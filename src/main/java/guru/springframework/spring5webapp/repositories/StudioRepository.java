package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Studio;
import org.springframework.data.repository.CrudRepository;

public interface StudioRepository extends CrudRepository<Studio, Long>  {
}
