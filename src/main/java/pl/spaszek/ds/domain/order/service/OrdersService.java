package pl.spaszek.ds.domain.order.service;

import pl.spaszek.ds.domain.order.entity.Order;

import java.util.List;

public interface OrdersService {

    List<Order> getAllOrders(String providerApiKey);
    List<Order> getAllActiveOrders(String providerApiKey);
    List<Order> getAllDeliveredOrders(String providerApiKey);


}
