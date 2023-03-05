package br.com.cwi.sweetbook.service.posts;

import br.com.cwi.sweetbook.controller.response.PostDetalhadoResponse;
import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.mapper.PostDetalhadoMapper;
import br.com.cwi.sweetbook.repository.PostRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.service.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MostrarPostsUsuarioService {

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    PostRepository postRepository;

    public Page<PostDetalhadoResponse> mostrar(Long usuarioId, Pageable pageable) {

        Usuario usuario = buscarUsuarioPorIdService.porId(usuarioId);

        Page<Postagem> posts = postRepository.findByQuemPostou(usuario, pageable);

        Page<PostDetalhadoResponse> response = posts.map(postagem -> PostDetalhadoMapper.toResponse(postagem));

        return response;
    }
}
