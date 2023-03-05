package br.com.cwi.sweetbook.service.posts;

import br.com.cwi.sweetbook.domain.Curtida;
import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.repository.CurtidaRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.service.UsuarioAutenticadoService;
import br.com.cwi.sweetbook.service.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RemoverCurtirPostService {

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    BuscarPostagemPorIdService buscarPostagemPorIdService;

    @Autowired
    CurtidaRepository curtidaRepository;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Transactional
    public void removerCurtir(Long postagemId) {

        Long usuarioId = usuarioAutenticadoService.getId();

        Usuario usuario = buscarUsuarioPorIdService.porId(usuarioId);

        Postagem postagem =  buscarPostagemPorIdService.porId(postagemId);

        Curtida curtida = curtidaRepository.findByPostagemCurtidaAndQuemCurtiu(postagem, usuario);

        usuario.removerCurtida(curtida);
        postagem.removerCurtida(curtida);

        curtidaRepository.deleteById(curtida.getId());
    }
}
