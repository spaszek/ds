package pl.spaszek.ds.domain.order.entity;

import pl.spaszek.ds.application.util.ApplicationConstants;
import pl.spaszek.ds.domain.order.util.OrderStatus;
import pl.spaszek.ds.domain.order.util.PaymentType;
import pl.spaszek.ds.domain.courier.entity.Courier;
import pl.spaszek.ds.domain.provider.entity.Provider;
import pl.spaszek.ds.domain.util.entity.AbstractEntity;
import pl.spaszek.ds.domain.util.entity.Address;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = Order.TABLE_NAME, schema = ApplicationConstants.DATABASE_SCHEMA)
public class Order extends AbstractEntity {

    public static final String TABLE_NAME = "orders";

    public static final String D_COURIER = "courier";
    public static final String D_PROVIDER = "provider";

    private static final String C_ORDER_STATUS = "order_status";
    private static final String C_PAYMENT_TYPE = "payment_type";
    private static final String C_EXPECTED_TO_COLLECT = "expected_to_collect";
    private static final String C_JSON_PRODUCTS = "json_products";
    private static final String C_TAKEN_AT = "taken_at";
    private static final String C_COLLECTED_AT = "collected_at";
    private static final String C_DELIVERED_AT = "delivered_at";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id")
    public Courier courier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    public Provider provider;

    @Enumerated(EnumType.STRING)
    @Column(name = C_ORDER_STATUS)
    public OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = C_PAYMENT_TYPE)
    public PaymentType paymentType;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address deliveryAddress;

    @Column
    public BigInteger value;

    @Column
    public Date created;

    @Column(name = C_EXPECTED_TO_COLLECT)
    public Date expectedToCollect;

    @Column(name = C_TAKEN_AT)
    public Date takenAt;

    @Column(name = C_COLLECTED_AT)
    public Date collectedAt;

    @Column(name = C_DELIVERED_AT)
    public Date deliveredAt;

    @Column(name = C_JSON_PRODUCTS)
    public String jsonProducts;

    public void changeStatus(OrderStatus orderStatus) {}

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getExpectedToCollect() {
        return expectedToCollect;
    }

    public void setExpectedToCollect(Date expectedToCollect) {
        this.expectedToCollect = expectedToCollect;
    }

    public Date getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(Date takenAt) {
        this.takenAt = takenAt;
    }

    public Date getCollectedAt() {
        return collectedAt;
    }

    public void setCollectedAt(Date collectedAt) {
        this.collectedAt = collectedAt;
    }

    public Date getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(Date deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public String getJsonProducts() {
        return jsonProducts;
    }

    public void setJsonProducts(String jsonProducts) {
        this.jsonProducts = jsonProducts;
    }

    public static class Builder {
        final Order order;

        public Builder() {
            this.order = new Order();
        }

        public Builder withId(Long id) {
            this.order.setId(id);
            return this;
        }

        public Builder withOrderStatus(OrderStatus orderStatus) {
            this.order.setOrderStatus(orderStatus);
            return this;
        }

        public Order build() {
            return order;
        }
    }

}
