package pl.spaszek.ds.domain.order.service;

import org.springframework.http.ResponseEntity;
import pl.spaszek.ds.application.domain.OrderDTO;
import pl.spaszek.ds.domain.order.entity.Order;
import pl.spaszek.ds.domain.order.util.OrderStatus;

import java.util.Optional;

public interface OrderService {

    Order createOrder(OrderDTO orderDTO);
    Order cancelOrder(Long orderId);
    Order changeStatus(Long orderId);
    Optional<OrderStatus> getStatusById(Long orderId);
    Optional<Order> getOrder(Long orderId);

}
