package br.com.cwi.sweetbook.service.amizades;


import br.com.cwi.sweetbook.controller.response.EnviarSolicitacaoResponse;
import br.com.cwi.sweetbook.domain.Amizade;
import br.com.cwi.sweetbook.domain.Situacao;
import br.com.cwi.sweetbook.mapper.EnviarSolicitacaoMapper;
import br.com.cwi.sweetbook.repository.AmizadeRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.service.UsuarioAutenticadoService;
import br.com.cwi.sweetbook.service.usuario.BuscarUsuarioPorIdService;
import br.com.cwi.sweetbook.service.verificadores.VerificarSituacaoAceitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RemoverRelacaoService {

    @Autowired
    BuscarAmizadePorUsuariosService buscarAmizadePorUsuariosService;

    @Autowired
    VerificarSituacaoAceitoService verificarSituacaoAceitoService;

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    AmizadeRepository amizadeRepository;

    @Transactional
    public EnviarSolicitacaoResponse remover(Long usuarioId) {

        Long idEu = usuarioAutenticadoService.getId();
        Usuario eu = buscarUsuarioPorIdService.porId(idEu);
        Usuario outro = buscarUsuarioPorIdService.porId(usuarioId);

        Amizade amizade = buscarAmizadePorUsuariosService.buscar(eu, outro);

        amizade.setSituacao(Situacao.REMOVIDO);
        amizade.setDisponivelSolicitar(true);

        amizadeRepository.deleteById(amizade.getId());

        return EnviarSolicitacaoMapper.toResponse(amizade);
    }
}
