package Ncargo.ncargo.service.impl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ncargo.ncargo.common.CommonSvcImpl;
import Ncargo.ncargo.models.ususarioModel;
import Ncargo.ncargo.repository.usuarioRepository;
import Ncargo.ncargo.service.usuarioSvc;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;

@Slf4j
@Service
public class usuarioSvcImpl extends CommonSvcImpl<ususarioModel, usuarioRepository> implements usuarioSvc{
    public static Logger getLog() {
        return log;
    }

     @Autowired
    private usuarioRepository usRepository;

    public boolean validarUsuario(String correo, String contra) {
        Optional<ususarioModel> usuarioOpt = usRepository.findByCorreoAndContra(correo, contra);
        return usuarioOpt.isPresent();
    }
}
