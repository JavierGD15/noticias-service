package Ncargo.ncargo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Ncargo.ncargo.models.noticiasModel;
import Ncargo.ncargo.repository.noticiasRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/noticias")
public class noticiasController {

    @Autowired
    private noticiasRepository noticiasRepository;

    @GetMapping
    public List<noticiasModel> getAllNoticias() {
        return (List<noticiasModel>) noticiasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<noticiasModel> getNoticiaById(@PathVariable Integer id) {
        Optional<noticiasModel> noticia = noticiasRepository.findById(id);
        return noticia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public noticiasModel createNoticia(@RequestBody noticiasModel noticia) {
        return noticiasRepository.save(noticia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<noticiasModel> updateNoticia(@PathVariable Integer id, @RequestBody noticiasModel noticiaDetails) {
        Optional<noticiasModel> noticia = noticiasRepository.findById(id);
        if (noticia.isPresent()) {
            noticiasModel existingNoticia = noticia.get();
            existingNoticia.setTitulo(noticiaDetails.getTitulo());
            existingNoticia.setDescripcion(noticiaDetails.getDescripcion());
            existingNoticia.setFecha_creacion(noticiaDetails.getFecha_creacion());
            existingNoticia.setTexto(noticiaDetails.getTexto());
            existingNoticia.setEnlace_photo(noticiaDetails.getEnlace_photo());
            existingNoticia.setClasificacion(noticiaDetails.getClasificacion());
            return ResponseEntity.ok(noticiasRepository.save(existingNoticia));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoticia(@PathVariable Integer id) {
        if (noticiasRepository.existsById(id)) {
            noticiasRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

