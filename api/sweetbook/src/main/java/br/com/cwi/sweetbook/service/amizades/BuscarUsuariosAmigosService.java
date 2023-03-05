package br.com.cwi.sweetbook.service.amizades;

import br.com.cwi.sweetbook.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.sweetbook.mapper.UsuarioDetalhadoMapper;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.repository.UsuarioRepository;
import br.com.cwi.sweetbook.security.service.UsuarioAutenticadoService;
import br.com.cwi.sweetbook.service.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuscarUsuariosAmigosService {

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    ListarAmigosService listarAmigosService;

    public Page<UsuarioDetalhadoResponse> buscar(String pesquisa, Pageable pageable) {

        Long idUsuario = usuarioAutenticadoService.getId();
        Usuario usuario = buscarUsuarioPorIdService.porId(idUsuario);

        List<Usuario> amigos = listarAmigosService.listarAmigos(usuario).stream().collect(Collectors.toList());

        return usuarioRepository.findUsuarios(amigos, pesquisa, pageable).map(UsuarioDetalhadoMapper::toResponse);
    }
}
