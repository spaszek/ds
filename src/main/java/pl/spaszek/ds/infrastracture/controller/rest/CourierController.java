package pl.spaszek.ds.infrastracture.controller.rest;

import org.springframework.http.ResponseEntity;
import pl.spaszek.ds.infrastracture.domain.OrderDTO;
import pl.spaszek.ds.domain.order.util.OrderStatus;

import java.util.List;

public interface CourierController {

    List<OrderDTO> getNewOrders(Long courierId);
    List<OrderDTO> getActiveOrders(Long courierId);
    List<OrderDTO> getDeliveredOrders(Long courierId);

    ResponseEntity takeOrder(Long courierId, Long orderId);
    ResponseEntity updateStatus(Long courierId, Long orderId, OrderStatus newStatus);

}
