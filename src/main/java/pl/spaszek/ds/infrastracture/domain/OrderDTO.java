package pl.spaszek.ds.infrastracture.domain;

import pl.spaszek.ds.domain.order.entity.Order;

public class OrderDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static OrderDTO mapToDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        return orderDTO;
    }
}
