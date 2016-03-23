package pl.spaszek.ds.domain.order.service;

import org.springframework.stereotype.Service;
import pl.spaszek.ds.domain.order.entity.Order;
import pl.spaszek.ds.domain.order.util.OrderStatus;
import pl.spaszek.ds.infrastracture.domain.OrderDTO;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public Order cancelOrder(Long orderId) {
        return null;
    }

    @Override
    public Order changeStatus(Long orderId) {
        return null;
    }

    @Override
    public Optional<OrderStatus> getStatusById(Long orderId) {
        return null;
    }

    @Override
    public Optional<Order> getOrder(Long orderId) {
        return null;
    }
}
