package Ncargo.ncargo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ncargo.ncargo.common.CommonSvcImpl;
import Ncargo.ncargo.models.clasificacionModel;
import Ncargo.ncargo.models.noticiasModel;
import Ncargo.ncargo.repository.clasificacionRepository;
import Ncargo.ncargo.repository.noticiasRepository;
import Ncargo.ncargo.service.noticiaSvc;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.slf4j.Logger;

@Slf4j
@Service
public class noticiasSvcImpl extends CommonSvcImpl<noticiasModel, noticiasRepository> implements noticiaSvc {
    @Autowired
    private noticiasRepository noticiasRepository;

    @Autowired
    private clasificacionRepository clasificacionRepository;

    public static Logger getLog() {
        return log;
    }

    @Override
    public List<noticiasModel> getNoticiasPorClasificacion(String nombreClasificacion) {
        clasificacionModel clasificacion = clasificacionRepository.findByNombre(nombreClasificacion);

        // Si la clasificación existe, buscar las noticias asociadas a esa clasificación
        if (clasificacion != null) {
            return noticiasRepository.findByClasificacion(clasificacion);
        } else {
            throw new RuntimeException("Clasificación no encontrada");
        }
    }

}
