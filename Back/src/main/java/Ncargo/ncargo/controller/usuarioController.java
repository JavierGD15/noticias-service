package Ncargo.ncargo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Ncargo.ncargo.models.ususarioModel;
import Ncargo.ncargo.repository.usuarioRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class usuarioController {

    @Autowired
    private usuarioRepository usuarioRepository;

    @GetMapping
    public List<ususarioModel> getAllUsuarios() {
        return (List<ususarioModel>) usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ususarioModel> getUsuarioById(@PathVariable Integer id) {
        Optional<ususarioModel> usuario = usuarioRepository.findById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ususarioModel createUsuario(@RequestBody ususarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ususarioModel> updateUsuario(@PathVariable Integer id, @RequestBody ususarioModel usuarioDetails) {
        Optional<ususarioModel> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            ususarioModel existingUsuario = usuario.get();
            existingUsuario.setNombre(usuarioDetails.getNombre());
            existingUsuario.setApellido(usuarioDetails.getApellido());
            existingUsuario.setEdad(usuarioDetails.getEdad());
            existingUsuario.setCorreo(usuarioDetails.getCorreo());
            existingUsuario.setContra(usuarioDetails.getContra());
            return ResponseEntity.ok(usuarioRepository.save(existingUsuario));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

