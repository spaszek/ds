package pl.spaszek.ds.application.controller.rest;

import pl.spaszek.ds.application.domain.OrderDTO;
import pl.spaszek.ds.domain.order.util.OrderStatus;

import java.util.List;

public interface AdminOrderController {

    List<OrderDTO> getAllOrders();
    List<OrderDTO> getActiveOrders();
    List<OrderDTO> getOrdersWithStatus(OrderStatus orderStatus);
}
