package br.com.cwi.sweetbook.service.posts;

import br.com.cwi.sweetbook.controller.request.ComentarPostRequest;
import br.com.cwi.sweetbook.domain.Comentario;
import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.mapper.FazerComentarioMapper;
import br.com.cwi.sweetbook.repository.ComentarioRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.service.UsuarioAutenticadoService;
import br.com.cwi.sweetbook.service.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentarPostService {

    @Autowired
    BuscarPostagemPorIdService buscarPostagemPorIdService;

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Transactional
    public void comentar(Long postagemId, ComentarPostRequest request) {

        Long usuarioId = usuarioAutenticadoService.getId();
        Usuario usuario = buscarUsuarioPorIdService.porId(usuarioId);
        Postagem postagem = buscarPostagemPorIdService.porId(postagemId);

        Comentario comentario = FazerComentarioMapper.toEntity(request);

        usuario.comentar(comentario);
        postagem.serComentada(comentario);

        comentarioRepository.save(comentario);
    }
}
