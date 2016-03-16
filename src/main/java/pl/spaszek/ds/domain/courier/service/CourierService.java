package pl.spaszek.ds.domain.courier.service;

import pl.spaszek.ds.domain.courier.entity.Courier;
import pl.spaszek.ds.domain.order.entity.Order;
import pl.spaszek.ds.domain.order.util.OrderStatus;

import java.util.List;

public interface CourierService {

    Courier getLoggedCourier();
    boolean takeOrder(Courier courier, Long orderId);
    Order changeStatus(Long courierId, Long orderId, OrderStatus orderStatus);
    List<Order> findAllCompleted(Long courierId);


}

