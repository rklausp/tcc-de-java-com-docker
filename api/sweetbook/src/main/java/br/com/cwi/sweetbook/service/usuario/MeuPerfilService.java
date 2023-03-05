package br.com.cwi.sweetbook.service.usuario;


import br.com.cwi.sweetbook.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.sweetbook.mapper.UsuarioDetalhadoMapper;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeuPerfilService {

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    public UsuarioDetalhadoResponse detalhar() {

        Long usuarioId = usuarioAutenticadoService.getId();
        Usuario usuario = buscarUsuarioPorIdService.porId(usuarioId);
        return UsuarioDetalhadoMapper.toResponse(usuario);

    }
}
