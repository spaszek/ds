package pl.spaszek.ds.domain.order.repository;

import org.springframework.data.repository.CrudRepository;
import pl.spaszek.ds.domain.order.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
