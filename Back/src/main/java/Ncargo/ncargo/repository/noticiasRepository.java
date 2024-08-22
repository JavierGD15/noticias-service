package Ncargo.ncargo.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Ncargo.ncargo.models.clasificacionModel;
import Ncargo.ncargo.models.noticiasModel;

public interface noticiasRepository extends CrudRepository<noticiasModel, Object>{
     List<noticiasModel> findByClasificacion(clasificacionModel clasificacion);
}
