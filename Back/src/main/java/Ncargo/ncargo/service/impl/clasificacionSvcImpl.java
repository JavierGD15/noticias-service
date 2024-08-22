package Ncargo.ncargo.service.impl;

import org.springframework.stereotype.Service;

import Ncargo.ncargo.common.CommonSvcImpl;
import Ncargo.ncargo.models.clasificacionModel;
import Ncargo.ncargo.repository.clasificacionRepository;
import Ncargo.ncargo.service.clasificacionSvc;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
@Service
public class clasificacionSvcImpl extends CommonSvcImpl<clasificacionModel, clasificacionRepository> implements clasificacionSvc{
    public static Logger getLog() {
        return log;
    }

}
