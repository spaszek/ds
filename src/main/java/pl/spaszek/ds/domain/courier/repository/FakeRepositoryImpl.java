package pl.spaszek.ds.domain.courier.repository;

import pl.spaszek.ds.domain.courier.entity.Courier;
import pl.spaszek.ds.domain.util.entity.AbstractEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

public class FakeRepositoryImpl<E extends AbstractEntity, ID extends Serializable> implements FakeRepository<E, ID> {

    final Collection<E> database;

    public FakeRepositoryImpl() {
        database = new LinkedList<>();
    }

    @Override
    public void delete(E entity) {
        database.remove(entity);
    }

    @Override
    public E save(E entity) {
        if (database.stream().filter(e -> Objects.equals(e.getId(), entity.getId())).findAny().isPresent()) {
            this.merge(entity, database);
        } else {
            database.add(entity);
        }
        return entity;
    }

    @Override
    public Optional<E> find(ID id) {
        return database.stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny();
    }

    @Override
    public Collection<E> findAll() {
        return database;
    }

    @Override
    public long countAll() {
        return database.size();
    }

    void addForTesting(Collection<E> collection) {
        database.addAll(collection);
    }

    private void merge(E entity, Collection<E> database) {
        E fromDatabase = database.stream().filter(e -> Objects.equals(e.getId(), entity.getId())).findAny().get();
        //tu sie robi merge z db
        database.remove(fromDatabase);
        database.add(entity);
    }
}
