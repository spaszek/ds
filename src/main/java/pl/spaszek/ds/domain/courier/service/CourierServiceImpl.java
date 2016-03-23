package pl.spaszek.ds.domain.courier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.spaszek.ds.domain.courier.entity.Courier;
import pl.spaszek.ds.domain.order.entity.Order;
import pl.spaszek.ds.domain.order.service.OrderService;
import pl.spaszek.ds.domain.order.util.OrderStatus;

import java.util.List;

@Service
public class CourierServiceImpl implements CourierService {

    @Autowired private OrderService orderService;

    @Override
    public Courier getLoggedCourier() {
        return null;
    }

    @Override
    public boolean takeOrder(Courier courier, Long orderId) {
        return false;
    }

    @Override
    public Order changeStatus(Long courierId, Long orderId, OrderStatus orderStatus) {
        return null;
    }

    @Override
    public List<Order> findAllCompleted(Long courierId) {
        return null;
    }
}
