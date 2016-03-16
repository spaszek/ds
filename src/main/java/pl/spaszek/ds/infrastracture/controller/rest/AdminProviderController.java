package pl.spaszek.ds.infrastracture.controller.rest;

import org.springframework.http.ResponseEntity;
import pl.spaszek.ds.application.domain.ProviderDTO;

import java.util.List;

public interface AdminProviderController {

    ResponseEntity createNewProvider(ProviderDTO providerDTO);
    ResponseEntity disableProvider(Long providerId);
    List<ProviderDTO> getAllProviders();

}
