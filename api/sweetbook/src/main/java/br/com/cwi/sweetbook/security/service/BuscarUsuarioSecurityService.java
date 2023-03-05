package br.com.cwi.sweetbook.security.service;

import br.com.cwi.sweetbook.security.UsuarioSecurity;
import br.com.cwi.sweetbook.security.repository.UsuarioRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioSecurityService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return new UsuarioSecurity(usuario);
    }
}
