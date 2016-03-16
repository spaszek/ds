package pl.spaszek.ds.domain.provider.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import pl.spaszek.ds.application.util.ApplicationConstants;
import pl.spaszek.ds.domain.order.entity.Order;
import pl.spaszek.ds.domain.provider.vo.ApiInfo;
import pl.spaszek.ds.domain.util.entity.AbstractEntity;
import pl.spaszek.ds.domain.util.entity.Address;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = Provider.TABLE_NAME, schema = ApplicationConstants.DATABASE_SCHEMA)
public class Provider extends AbstractEntity {

    public static final String TABLE_NAME = "providers";

    private static final String C_ACTIVE_SINCE = "active_since";
    private static final String C_DEACTIVATED_AT = "decativated_at";
    private static final String C_MARGIN_RATE = "margin_rate";
    private static final String C_PENALTY_RATE = "penalty_rate";

    @LazyCollection(LazyCollectionOption.EXTRA)
    @OneToMany(mappedBy = Order.D_PROVIDER)
    private Set<Order> orders;

    @Embedded
    private ApiInfo apiInfo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column
    private boolean inactive;

    @Column(name = C_ACTIVE_SINCE)
    private Date activeSince;

    @Column(name = C_DEACTIVATED_AT)
    private Date deactivatedAt;

    @Column(name = C_MARGIN_RATE)
    private BigInteger marginRate;

    @Column(name = C_PENALTY_RATE)
    private BigInteger expiredPenaltyRate;

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public ApiInfo getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(ApiInfo apiInfo) {
        this.apiInfo = apiInfo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public Date getActiveSince() {
        return activeSince;
    }

    public void setActiveSince(Date activeSince) {
        this.activeSince = activeSince;
    }

    public Date getDeactivatedAt() {
        return deactivatedAt;
    }

    public void setDeactivatedAt(Date deactivatedAt) {
        this.deactivatedAt = deactivatedAt;
    }

    public BigInteger getMarginRate() {
        return marginRate;
    }

    public void setMarginRate(BigInteger marginRate) {
        this.marginRate = marginRate;
    }

    public BigInteger getExpiredPenaltyRate() {
        return expiredPenaltyRate;
    }

    public void setExpiredPenaltyRate(BigInteger expiredPenaltyRate) {
        this.expiredPenaltyRate = expiredPenaltyRate;
    }
}
