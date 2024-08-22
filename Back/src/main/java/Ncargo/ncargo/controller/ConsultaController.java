package Ncargo.ncargo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultaController {
    


    @GetMapping(value = "/Consultorio_list")
    private String listarConsultorio() {
        return "Hola mundo";
    }
}
