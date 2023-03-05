package br.com.cwi.sweetbook.security.service;

import br.com.cwi.sweetbook.security.controller.response.UsuarioResponse;
import br.com.cwi.sweetbook.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.sweetbook.security.mapper.UsuarioMapper.toResponse;

@Service
public class BuscarUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public UsuarioResponse buscar() {
        Usuario usuarioAutenticado = usuarioAutenticadoService.get();
        return toResponse(usuarioAutenticado);
    }
}
