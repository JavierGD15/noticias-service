package Ncargo.ncargo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Ncargo.ncargo.models.clasificacionModel;
import Ncargo.ncargo.models.noticiasModel;
import Ncargo.ncargo.repository.clasificacionRepository;
import Ncargo.ncargo.service.noticiaSvc;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clasificaciones")
@CrossOrigin
public class clasificacionController {

    @Autowired
    private clasificacionRepository clasificacionRepository;

    @GetMapping
    public List<clasificacionModel> getAllClasificaciones() {
        return (List<clasificacionModel>) clasificacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<clasificacionModel> getClasificacionById(@PathVariable Integer id) {
        Optional<clasificacionModel> clasificacion = clasificacionRepository.findById(id);
        return clasificacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public clasificacionModel createClasificacion(@RequestBody clasificacionModel clasificacion) {
        return clasificacionRepository.save(clasificacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<clasificacionModel> updateClasificacion(@PathVariable Integer id, @RequestBody clasificacionModel clasificacionDetails) {
        Optional<clasificacionModel> clasificacion = clasificacionRepository.findById(id);
        if (clasificacion.isPresent()) {
            clasificacionModel existingClasificacion = clasificacion.get();
            existingClasificacion.setNombre(clasificacionDetails.getNombre());
            return ResponseEntity.ok(clasificacionRepository.save(existingClasificacion));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClasificacion(@PathVariable Integer id) {
        if (clasificacionRepository.existsById(id)) {
            clasificacionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
