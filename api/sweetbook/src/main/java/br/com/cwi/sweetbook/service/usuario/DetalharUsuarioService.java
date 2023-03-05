package br.com.cwi.sweetbook.service.usuario;

import br.com.cwi.sweetbook.controller.response.OutroUsuarioDetalhadoResponse;
import br.com.cwi.sweetbook.mapper.OutroUsuarioDetalhadoMapper;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.service.UsuarioAutenticadoService;
import br.com.cwi.sweetbook.service.verificadores.VerificarSeHaAmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalharUsuarioService {

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    VerificarSeHaAmizadeService verificarSeHaAmizadeService;

    public OutroUsuarioDetalhadoResponse detalhar(Long id){

        Usuario eu = usuarioAutenticadoService.get();
        Usuario usuario = buscarUsuarioPorIdService.porId(id);

        boolean isAmigo = verificarSeHaAmizadeService.verifica(eu, usuario);

        return OutroUsuarioDetalhadoMapper.toResponse(usuario, isAmigo);
    }
}
