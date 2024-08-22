package Ncargo.ncargo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Ncargo.ncargo.models.noticiasModel;
import Ncargo.ncargo.repository.noticiasRepository;
import Ncargo.ncargo.service.noticiaSvc;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/noticias")
public class noticiasController {

    @Autowired
    private noticiasRepository noticiasRepository;

    @Autowired
    private noticiaSvc noticiaService;

    @GetMapping
    public List<noticiasModel> getAllNoticias() {
        return (List<noticiasModel>) noticiasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<noticiasModel> getNoticiaById(@PathVariable Integer id) {
        Optional<noticiasModel> noticia = noticiasRepository.findById(id);
        return noticia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/clasificacion")
    public ResponseEntity<List<noticiasModel>> getNoticiasPorClasificacion(@RequestParam String nombreClasificacion) {
        List<noticiasModel> noticias = noticiaService.getNoticiasPorClasificacion(nombreClasificacion);
        return ResponseEntity.ok(noticias);
    }
}

