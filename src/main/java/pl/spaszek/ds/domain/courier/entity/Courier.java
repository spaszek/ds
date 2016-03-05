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

    public static final String D_VERIFIED_AT = "verified_at";
    public static final String D_SALARY_TYPE = "salary_type";

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    public Address address;

    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(mappedBy = Order.D_COURIER)
    public Set<Order> orders;

    @Column
    public boolean verified;

    @Column
    public boolean active;

    @Column(name = D_VERIFIED_AT)
    public Date verifiedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = D_SALARY_TYPE)
    public SalaryType salaryType;

    @Column
    public float rate;


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getVerifiedAt() {
        return verifiedAt;
    }

    public void setVerifiedAt(Date verifiedAt) {
        this.verifiedAt = verifiedAt;
    }

    public SalaryType getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(SalaryType salaryType) {
        this.salaryType = salaryType;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
