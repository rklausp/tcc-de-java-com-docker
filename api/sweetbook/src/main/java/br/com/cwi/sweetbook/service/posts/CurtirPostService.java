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
public class CurtirPostService {

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    BuscarPostagemPorIdService buscarPostagemPorIdService;

    @Autowired
    CurtidaRepository curtidaRepository;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Transactional
    public void curtir(Long postagemId) {

        Long usuarioId = usuarioAutenticadoService.getId();

        Usuario usuario = buscarUsuarioPorIdService.porId(usuarioId);

        Postagem postagem =  buscarPostagemPorIdService.porId(postagemId);

        Curtida curtida = new Curtida();

        usuario.curtir(curtida);
        postagem.serCurtida(curtida);

        curtidaRepository.save(curtida);
    }
}
