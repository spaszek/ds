package pl.spaszek.ds.domain.provider.repository;

import org.springframework.data.repository.CrudRepository;
import pl.spaszek.ds.domain.provider.entity.Provider;

public interface ProviderRepository extends CrudRepository<Provider, Long> {
}
