package pl.spaszek.ds.infrastracture.controller.rest;

import org.springframework.http.ResponseEntity;
import pl.spaszek.ds.infrastracture.domain.CourierDTO;

import java.util.List;
import java.util.Optional;

public interface AdminCourierController {

    List<CourierDTO> getAllCouriers(Boolean active);
    Optional<CourierDTO> getCourierData(Long courierId);

    ResponseEntity disableCourier(Long courierId);
    ResponseEntity verifyCourier(Long courierId);

}
