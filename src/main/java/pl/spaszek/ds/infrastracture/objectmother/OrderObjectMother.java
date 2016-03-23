package pl.spaszek.ds.infrastracture.objectmother;

import pl.spaszek.ds.domain.order.entity.Order;
import pl.spaszek.ds.domain.order.util.OrderStatus;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public abstract class OrderObjectMother {




    public static List<Order> createTwoWithStatus(OrderStatus orderStatus) {
        return newArrayList(
                new Order.Builder().withId(1L).withOrderStatus(orderStatus).build(),
                new Order.Builder().withId(2L).withOrderStatus(orderStatus).build()
        );
    }

}
