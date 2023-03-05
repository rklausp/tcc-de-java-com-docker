package br.com.cwi.sweetbook.service.usuario;

import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BuscarUsuarioPorIdService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario porId(Long id){
       return usuarioRepository.findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario nao encontrado!"));
    }
}
