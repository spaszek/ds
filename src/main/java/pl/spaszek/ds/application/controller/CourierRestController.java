package pl.spaszek.ds.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.spaszek.ds.domain.courier.entity.Courier;
import pl.spaszek.ds.domain.courier.service.CourierService;

@RestController
public class CourierRestController {

    private static final String BASE_URL = "/courier";
    private static final String TAKE_ORDER = "/take/{orderId}";

    @Autowired private CourierService courierService;

    @RequestMapping(value = BASE_URL + TAKE_ORDER)
    public ResponseEntity<String> takeOrder(@PathVariable Long orderId) {
        //dorobic zeby byla auth
        Courier loggedCourier = courierService.getLoggedCourier();
        boolean result = courierService.takeOrder(loggedCourier, orderId);

        return result ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }


}
