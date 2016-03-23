package pl.spaszek.ds.domain.order.repository;

import org.springframework.data.repository.CrudRepository;
import pl.spaszek.ds.domain.order.entity.Order;
import pl.spaszek.ds.domain.order.util.OrderStatus;

import java.util.Collection;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAllByCourier_IdAndByOrderStatus(Long courierId, OrderStatus orderStatus);
    List<Order> findAllByCourier_IdAndByOrderStatusNotIn(Long courierId, Collection<OrderStatus> orderStatusCollection);

}
