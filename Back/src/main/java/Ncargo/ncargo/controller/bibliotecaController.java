package Ncargo.ncargo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ncargo.ncargo.common.CommonController;
import Ncargo.ncargo.models.biblioteca;
import Ncargo.ncargo.service.bibliotecaSvc;
import Ncargo.ncargo.validator.bibliotecaValidator;

@RestController
@RequestMapping("/biblioteca")
public class bibliotecaController extends CommonController<biblioteca, bibliotecaSvc, bibliotecaValidator> {

    @GetMapping("/Admin")
    public List<biblioteca> ListarAdministradores() {
        return (List<biblioteca>) this.service.findAll();
    }
}
