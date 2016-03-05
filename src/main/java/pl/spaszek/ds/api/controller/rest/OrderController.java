package pl.spaszek.ds.api.controller.rest;

import org.springframework.http.ResponseEntity;
import pl.spaszek.ds.api.domain.OrderDTO;
import pl.spaszek.ds.domain.order.util.OrderStatus;

import java.util.Optional;

public interface OrderController {

    ResponseEntity createOrder(OrderDTO orderDTO);
    ResponseEntity cancelOrder(Long orderId);
    Optional<OrderStatus> getStatusById(Long orderId);
    Optional<OrderDTO> getOrder(Long orderId);

}
