package pl.spaszek.ds.domain.courier.repository;

import pl.spaszek.ds.domain.util.entity.AbstractEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface FakeRepository<E extends AbstractEntity, ID extends Serializable> {

    void delete(E entity);
    E save(E entity);
    Optional<E> find(ID id);
    Collection<E> findAll();
    long countAll();

}
