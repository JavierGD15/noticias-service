package Ncargo.ncargo.service;

import Ncargo.ncargo.common.CommonSvc;
import Ncargo.ncargo.models.ususarioModel;

public interface usuarioSvc extends CommonSvc<ususarioModel>{
    boolean validarUsuario(String correo, String contra);
}
