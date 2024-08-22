package Ncargo.ncargo.repository;

import org.springframework.data.repository.CrudRepository;

import Ncargo.ncargo.models.clasificacionModel;

public interface clasificacionRepository extends CrudRepository<clasificacionModel, Object>{
    clasificacionModel findByNombre(String nombre);
}
