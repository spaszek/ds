package pl.spaszek.ds.domain.courier.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import pl.spaszek.ds.application.util.ApplicationConstants;
import pl.spaszek.ds.domain.util.entity.AbstractEntity;
import pl.spaszek.ds.domain.util.entity.Address;
import pl.spaszek.ds.domain.order.entity.Order;
import pl.spaszek.ds.domain.order.util.SalaryType;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = Courier.TABLE_NAME, schema = ApplicationConstants.DATABASE_SCHEMA)
public class Courier extends AbstractEntity {

    public static final String TABLE_NAME = "couriers";

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    public Address address;

    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(mappedBy = Order.D_COURIER)
    public Set<Order> orders;

    public boolean verified;
    public boolean active;

    public Date verifiedAt;

    @Enumerated(EnumType.STRING)
    public SalaryType salaryType;

    public float rate;

}
