package Ncargo.ncargo.service;

import java.util.List;

import Ncargo.ncargo.common.CommonSvc;
import Ncargo.ncargo.models.noticiasModel;

public interface noticiaSvc extends CommonSvc<noticiasModel>{
List<noticiasModel> getNoticiasPorClasificacion(String nombreClasificacion);
}
