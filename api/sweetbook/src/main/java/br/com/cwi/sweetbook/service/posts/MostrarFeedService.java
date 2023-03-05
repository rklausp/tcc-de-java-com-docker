package br.com.cwi.sweetbook.service.posts;


import br.com.cwi.sweetbook.controller.response.PostDetalhadoResponse;
import br.com.cwi.sweetbook.mapper.PostDetalhadoMapper;
import br.com.cwi.sweetbook.repository.PostRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.service.UsuarioAutenticadoService;
import br.com.cwi.sweetbook.service.usuario.BuscarUsuarioPorIdService;
import br.com.cwi.sweetbook.service.amizades.ListarAmigosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MostrarFeedService {

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ListarAmigosService listarAmigosService;
    public Page<PostDetalhadoResponse> mostrar(Pageable pageable) {

        Long usuarioId = usuarioAutenticadoService.getId();
        Usuario usuario = buscarUsuarioPorIdService.porId(usuarioId);

        List<Usuario> amigos = listarAmigosService.listarAmigos(usuario);
        amigos.add(usuario);

        return postRepository.findPostsParaAparecer(amigos, pageable)
                .map(PostDetalhadoMapper::toResponse);

    }
}
