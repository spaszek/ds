package pl.spaszek.ds.api.controller.rest;

import pl.spaszek.ds.application.domain.OrderDTO;

import java.util.List;

public interface OrdersController {

    List<OrderDTO> getAllOrders(String providerApiKey);
    List<OrderDTO> getAllActiveOrders(String providerApiKey);
    List<OrderDTO> getAllDeliveredOrders(String providerApiKey);


}
