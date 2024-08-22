package Ncargo.ncargo.service.impl;

import org.springframework.stereotype.Service;

import Ncargo.ncargo.common.CommonSvcImpl;
import Ncargo.ncargo.models.biblioteca;
import Ncargo.ncargo.repository.bibliotecaReposotory;
import Ncargo.ncargo.service.bibliotecaSvc;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
@Service
public class bibliotecaSvcImpl extends CommonSvcImpl<biblioteca, bibliotecaReposotory> implements bibliotecaSvc{
    public static Logger getLog() {
        return log;
    }

}
