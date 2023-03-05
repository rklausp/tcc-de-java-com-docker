package br.com.cwi.sweetbook.service.posts;

import br.com.cwi.sweetbook.controller.response.PostDetalhadoResponse;
import br.com.cwi.sweetbook.domain.Tipo;
import br.com.cwi.sweetbook.mapper.PostDetalhadoMapper;
import br.com.cwi.sweetbook.repository.PostRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.service.UsuarioAutenticadoService;
import br.com.cwi.sweetbook.service.usuario.BuscarUsuarioPorIdService;
import br.com.cwi.sweetbook.service.verificadores.VerificarSeHaAmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MostrarPostsOutroUsuarioService {

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    VerificarSeHaAmizadeService verificarSeHaAmizadeService;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    public Page<PostDetalhadoResponse> mostrar(Long usuarioId, Pageable pageable) {


        Long id = usuarioAutenticadoService.getId();
        Usuario eu = buscarUsuarioPorIdService.porId(id);
        Usuario outro = buscarUsuarioPorIdService.porId(usuarioId);

        boolean isAmigos = verificarSeHaAmizadeService.verifica(eu, outro);

        if(isAmigos){
            return postRepository.findByQuemPostou(outro, pageable).map(PostDetalhadoMapper::toResponse);
        }
        return postRepository.findByQuemPostouAndTipo(outro, Tipo.PUBLICO, pageable).map(PostDetalhadoMapper::toResponse);
    }
}
