package Ncargo.ncargo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Ncargo.ncargo.models.ususarioModel;
import Ncargo.ncargo.repository.usuarioRepository;
import java.util.ArrayList;
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private usuarioRepository usRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        ususarioModel usuario = usRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
      
        return new org.springframework.security.core.userdetails.User(usuario.getCorreo(), usuario.getContra(), new ArrayList<>());
    }
}
