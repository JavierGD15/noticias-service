package Ncargo.ncargo.controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import Ncargo.ncargo.DTO.LoginRequest;
import Ncargo.ncargo.models.ususarioModel;
import Ncargo.ncargo.repository.usuarioRepository;
import Ncargo.ncargo.service.JwtUtil;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class usuarioController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private usuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody ususarioModel usuario) {
        // Cifrar la contraseña antes de guardarla en la base de datos
        usuario.setContra(passwordEncoder.encode(usuario.getContra()));
        usuarioRepository.save(usuario);
        Map<String, String> response = new HashMap<>();
            response.put("mensaje", "Usuario registrado con éxito");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Autentica al usuario usando AuthenticationManager
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getCorreo(), loginRequest.getContra()));

            // Si la autenticación es exitosa, generar el token JWT
            final String jwt = jwtUtil.generateToken(loginRequest.getCorreo());
             Map<String, String> response = new HashMap<>();
            response.put("token", jwt);
            return ResponseEntity.ok(response);

        } catch (BadCredentialsException e) {
            // Si las credenciales son incorrectas
            return ResponseEntity.status(400).body("Credenciales incorrectas");
        }
    }
}
