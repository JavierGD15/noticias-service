package Ncargo.ncargo.service.impl;

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

}
