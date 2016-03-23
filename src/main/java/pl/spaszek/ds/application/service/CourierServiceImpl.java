package pl.spaszek.ds.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.spaszek.ds.domain.courier.entity.Courier;
import pl.spaszek.ds.domain.courier.repository.CourierRepository;
import pl.spaszek.ds.domain.order.entity.Order;
import pl.spaszek.ds.domain.order.repository.OrderRepository;
import pl.spaszek.ds.domain.order.util.OrderStatus;
import pl.spaszek.ds.infrastracture.domain.OrderDTO;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class CourierServiceImpl implements CourierService {

    @Autowired private CourierRepository courierRepository;
    @Autowired private OrderRepository orderRepository;

    @Override
    public List<OrderDTO> getNewOrders(Long courierId) {
        return orderRepository.findAllByCourier_IdAndByOrderStatus(courierId, OrderStatus.NEW)
                .stream()
                .map(OrderDTO::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getActiveOrders(Long courierId) {
        return orderRepository.findAllByCourier_IdAndByOrderStatusNotIn(courierId,
                newArrayList(OrderStatus.NEW, OrderStatus.NOT_ACCEPTED, OrderStatus.NOT_PICKED_UP, OrderStatus.EXPIRED, OrderStatus.FINALIZED
                )).stream()
                .map(OrderDTO::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getDeliveredOrders(Long courierId) {
        return orderRepository.findAllByCourier_IdAndByOrderStatus(courierId, OrderStatus.FINALIZED)
                .stream()
                .map(OrderDTO::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean takeOrder(Long courierId, Long orderId) {
        final Courier courier = courierRepository.findOne(courierId);
        final Order order = orderRepository.findOne(orderId);

        order.setCourier(courier);
        order.setTakenAt(new Date());
        order.setOrderStatus(OrderStatus.TAKEN);

        return orderRepository.save(order) != null;
    }

    @Override
    public boolean updateStatus(Long courierId, Long orderId, OrderStatus newStatus) {
        final Courier courier = courierRepository.findOne(courierId);
        final Order order = orderRepository.findOne(orderId);

        Assert.isTrue(order.getCourier().equals(courier));

        order.changeStatus(newStatus);

        return orderRepository.save(order) != null;
    }
}
