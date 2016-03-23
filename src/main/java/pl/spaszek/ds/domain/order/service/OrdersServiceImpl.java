package pl.spaszek.ds.domain.order.service;

import org.springframework.stereotype.Service;
import pl.spaszek.ds.domain.order.entity.Order;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Override
    public List<Order> getAllOrders(String providerApiKey) {
        return null;
    }

    @Override
    public List<Order> getAllActiveOrders(String providerApiKey) {
        return null;
    }

    @Override
    public List<Order> getAllDeliveredOrders(String providerApiKey) {
        return null;
    }
}
