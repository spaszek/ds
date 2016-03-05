package pl.spaszek.ds.domain.order.entity;

import pl.spaszek.ds.application.util.ApplicationConstants;
import pl.spaszek.ds.domain.util.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = OrderEvent.TABLE_NAME, schema = ApplicationConstants.DATABASE_SCHEMA)
public class OrderEvent extends AbstractEntity {
    public static final String TABLE_NAME = "order_events";
}
