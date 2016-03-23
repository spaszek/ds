package pl.spaszek.ds.application.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.spaszek.ds.domain.courier.entity.Courier;
import pl.spaszek.ds.domain.courier.repository.CourierRepository;
import pl.spaszek.ds.domain.order.entity.Order;
import pl.spaszek.ds.domain.order.repository.OrderRepository;
import pl.spaszek.ds.domain.order.util.OrderStatus;
import pl.spaszek.ds.infrastracture.domain.OrderDTO;
import pl.spaszek.ds.infrastracture.objectmother.OrderObjectMother;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CourierServiceImplTest {

    @InjectMocks private CourierServiceImpl courierService;
    @Mock private CourierRepository courierRepository;
    @Mock private OrderRepository orderRepository;

    @Test
    public void shouldGetProperNewOrders() throws Exception {
        //given
        given(orderRepository.findAllByCourier_IdAndByOrderStatus(any(), any())).willReturn(OrderObjectMother.createTwoWithStatus(OrderStatus.NEW));

        //when
        final List<OrderDTO> result = courierService.getNewOrders(1L);

        //then
        assertThat(result.stream().map(OrderDTO::getId)).containsExactly(1L, 2L);
    }

    @Test
    public void shouldProperlyTakeOrder() throws Exception {
        //given
        final Order order = new Order.Builder().withId(1L).build();
        final Courier courier = new Courier();

        given(orderRepository.findOne(any())).willReturn(order);
        given(courierRepository.findOne(any())).willReturn(courier);

        when(orderRepository.save(any(Order.class))).then(returnsFirstArg());

        //when
        final boolean result = courierService.takeOrder(1L, 1L);

        //assert
        assertThat(result).isTrue();
        assertThat(order.getOrderStatus()).isEqualTo(OrderStatus.TAKEN);
        assertThat(order.getTakenAt()).isNotNull();
        assertThat(order.getTakenAt()).isBefore(new Date());


    }



}