package pl.spaszek.ds.domain.order.entity;

import pl.spaszek.ds.application.util.ApplicationConstants;
import pl.spaszek.ds.domain.order.util.OrderStatus;
import pl.spaszek.ds.domain.order.util.PaymentType;
import pl.spaszek.ds.domain.courier.entity.Courier;
import pl.spaszek.ds.domain.provider.entity.Provider;
import pl.spaszek.ds.domain.util.entity.AbstractEntity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = Order.TABLE_NAME, schema = ApplicationConstants.DATABASE_SCHEMA)
public class Order extends AbstractEntity {

    public static final String TABLE_NAME = "orders";

    public static final String D_COURIER = "courier";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id")
    public Courier courier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    public Provider provider;

    @Enumerated(EnumType.STRING)
    public OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    public PaymentType paymentType;

    public BigInteger value;

    public Date created;
    public Date expectedToCollect;
    public Date takenAt;
    public Date collectedAt;
    public Date deliveredAt;

    public String jsonProducts;

}
