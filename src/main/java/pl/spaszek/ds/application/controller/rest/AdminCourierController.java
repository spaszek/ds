package pl.spaszek.ds.application.controller.rest;

import org.springframework.http.ResponseEntity;
import pl.spaszek.ds.application.domain.CourierDTO;

import java.util.List;
import java.util.Optional;

public interface AdminCourierController {

    List<CourierDTO> getAllCouriers(Boolean active);
    Optional<CourierDTO> getCourierData(Long courierId);

    ResponseEntity disableCourier(Long courierId);
    ResponseEntity verifyCourier(Long courierId);

}
