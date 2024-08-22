package Ncargo.ncargo.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import Ncargo.ncargo.models.ususarioModel;

public interface usuarioRepository extends CrudRepository<ususarioModel, Object> {
    Optional<ususarioModel> findByCorreo(String correo);
    Optional<ususarioModel> findByCorreoAndContra(String correo, String contra);
    
}