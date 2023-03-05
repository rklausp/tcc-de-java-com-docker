package br.com.cwi.sweetbook.service.amizades;

import br.com.cwi.sweetbook.controller.response.AceitarSolicitacaoResponse;
import br.com.cwi.sweetbook.domain.Amizade;
import br.com.cwi.sweetbook.domain.Situacao;
import br.com.cwi.sweetbook.mapper.AceitarSolicitacaoMapper;
import br.com.cwi.sweetbook.repository.AmizadeRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.service.verificadores.VerificarSituacaoSolicitadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AceitarSolicitacaoService {

    @Autowired
    BuscarAmizadePorIdService buscarAmizadePorIdService;

    @Autowired
    VerificarSituacaoSolicitadaService verificarSituacaoSolicitadaService;

    @Autowired
    AmizadeRepository amizadeRepository;

    @Transactional
    public AceitarSolicitacaoResponse aceitar(Long amizadeId) {

        Amizade amizade = buscarAmizadePorIdService.porId(amizadeId);

        verificarSituacaoSolicitadaService.verificar(amizade);

        amizade.setSituacao(Situacao.ACEITO);

        amizadeRepository.save(amizade);

        return AceitarSolicitacaoMapper.toResponse(amizade);
    }
}
