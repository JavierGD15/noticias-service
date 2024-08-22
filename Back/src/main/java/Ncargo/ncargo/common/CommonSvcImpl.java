package Ncargo.ncargo.common;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public class CommonSvcImpl<E, R extends CrudRepository<E, Object>> implements CommonSvc<E> {

    @Autowired
    protected R repository;

    @Override
    @Transactional
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Optional<E> findById(Object id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Object id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Iterable<E> saveAll(Iterable<E> entities) {
        return repository.saveAll(entities);
    }

}

