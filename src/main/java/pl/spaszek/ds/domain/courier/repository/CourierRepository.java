package pl.spaszek.ds.domain.courier.repository;

import org.springframework.data.repository.CrudRepository;
import pl.spaszek.ds.domain.courier.entity.Courier;

public interface CourierRepository extends CrudRepository<Courier, Long> {
}
