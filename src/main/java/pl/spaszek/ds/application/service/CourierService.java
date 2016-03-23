package pl.spaszek.ds.application.service;

import org.springframework.http.ResponseEntity;
import pl.spaszek.ds.infrastracture.domain.OrderDTO;
import pl.spaszek.ds.domain.order.util.OrderStatus;

import java.util.List;

public interface CourierService {

    List<OrderDTO> getNewOrders(Long courierId);
    List<OrderDTO> getActiveOrders(Long courierId);
    List<OrderDTO> getDeliveredOrders(Long courierId);

    boolean takeOrder(Long courierId, Long orderId);
    boolean updateStatus(Long courierId, Long orderId, OrderStatus newStatus);

}
