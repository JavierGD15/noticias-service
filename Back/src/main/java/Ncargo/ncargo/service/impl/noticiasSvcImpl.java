package Ncargo.ncargo.service.impl;

import org.springframework.stereotype.Service;

import Ncargo.ncargo.common.CommonSvcImpl;
import Ncargo.ncargo.models.noticiasModel;
import Ncargo.ncargo.repository.noticiasRepository;
import Ncargo.ncargo.service.noticiaSvc;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
@Service
public class noticiasSvcImpl extends CommonSvcImpl<noticiasModel, noticiasRepository> implements noticiaSvc{
    public static Logger getLog() {
        return log;
    }

}
