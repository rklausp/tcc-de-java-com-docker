package br.com.cwi.sweetbook.service.posts;

import br.com.cwi.sweetbook.controller.request.FazerPostRequest;
import br.com.cwi.sweetbook.controller.response.PostDetalhadoResponse;
import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.mapper.FazerPostMapper;
import br.com.cwi.sweetbook.repository.PostRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.service.UsuarioAutenticadoService;
import br.com.cwi.sweetbook.service.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FazerPostService {

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Transactional
    public PostDetalhadoResponse postar(FazerPostRequest request) {

        Long usuarioId = usuarioAutenticadoService.getId();

        Usuario usuario = buscarUsuarioPorIdService.porId(usuarioId);

        Postagem post = FazerPostMapper.toEntity(request);

        usuario.fazerPost(post);

        postRepository.save(post);

        return FazerPostMapper.toResponse(post);
    }
}
