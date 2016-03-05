package pl.spaszek.ds.domain.util.entity;

import pl.spaszek.ds.application.util.ApplicationConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Address.TABLE_NAME, schema = ApplicationConstants.DATABASE_SCHEMA)
public class Address extends AbstractEntity {

    public static final String TABLE_NAME = "addresses";
    private static final String C_POSTAL_CODE = "postal_code";

    @Column
    public String street;
    @Column
    public String number;
    @Column(name = C_POSTAL_CODE)
    public String postalCode;
    @Column
    public String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
