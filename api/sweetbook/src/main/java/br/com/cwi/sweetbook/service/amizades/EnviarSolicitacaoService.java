package br.com.cwi.sweetbook.service.amizades;


import br.com.cwi.sweetbook.controller.response.EnviarSolicitacaoResponse;
import br.com.cwi.sweetbook.domain.Amizade;
import br.com.cwi.sweetbook.mapper.EnviarSolicitacaoMapper;
import br.com.cwi.sweetbook.repository.AmizadeRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.service.UsuarioAutenticadoService;
import br.com.cwi.sweetbook.service.usuario.BuscarUsuarioPorIdService;
import br.com.cwi.sweetbook.service.verificadores.VerificaSeJaHaRelacaoService;
import br.com.cwi.sweetbook.service.verificadores.VerificaSeUsuariosSaoIguaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnviarSolicitacaoService {

    @Autowired
    AmizadeRepository amizadeRepository;

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    VerificaSeUsuariosSaoIguaisService verificaSeUsuariosSaoIguaisService;

    @Autowired
    VerificaSeJaHaRelacaoService verificaSeJaHaRelacaoService;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;


    @Transactional
    public EnviarSolicitacaoResponse solicitar(Long usuarioId) {

        Long meuId = usuarioAutenticadoService.getId();
        Usuario solicitante = buscarUsuarioPorIdService.porId(meuId);
        Usuario solicitado = buscarUsuarioPorIdService.porId(usuarioId);

        verificaSeUsuariosSaoIguaisService.verifica(solicitante, solicitado);
        verificaSeJaHaRelacaoService.verifica(solicitante, solicitado);

        Amizade amizade = EnviarSolicitacaoMapper.toEntity();

        solicitante.enviarSolicitacao(amizade);
        solicitado.receberSolicitacao(amizade);

        amizadeRepository.save(amizade);

        return EnviarSolicitacaoMapper.toResponse(amizade);
    }
}
