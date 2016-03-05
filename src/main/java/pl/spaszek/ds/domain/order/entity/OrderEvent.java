package pl.spaszek.ds.domain.order.entity;

import pl.spaszek.ds.application.util.ApplicationConstants;
import pl.spaszek.ds.domain.order.util.EventType;
import pl.spaszek.ds.domain.util.entity.AbstractEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = OrderEvent.TABLE_NAME, schema = ApplicationConstants.DATABASE_SCHEMA)
public class OrderEvent extends AbstractEntity {
    public static final String TABLE_NAME = "order_events";
    private static final String C_SENT_TO_EXTERNAL_API = "sent_to_external_api";

    @Enumerated(EnumType.STRING)
    @Column
    public EventType eventType;

    @ManyToOne
    @JoinColumn(name = "order_id")
    public Order order;

    @Column
    public String before;

    @Column
    public String after;

    @Column
    public Date occured;

    @Column(name = C_SENT_TO_EXTERNAL_API)
    public boolean sentToExternalApi;

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public Date getOccured() {
        return occured;
    }

    public void setOccured(Date occured) {
        this.occured = occured;
    }

    public boolean isSentToExternalApi() {
        return sentToExternalApi;
    }

    public void setSentToExternalApi(boolean sentToExternalApi) {
        this.sentToExternalApi = sentToExternalApi;
    }
}
