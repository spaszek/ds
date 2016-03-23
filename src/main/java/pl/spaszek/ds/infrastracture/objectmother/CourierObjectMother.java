package pl.spaszek.ds.infrastracture.objectmother;

import pl.spaszek.ds.domain.courier.entity.Courier;

public abstract class CourierObjectMother {

    public static Courier createFakeCourier(Long id) {
        Courier courier = new Courier();
        courier.setId(id);
        return courier;
    }

}
