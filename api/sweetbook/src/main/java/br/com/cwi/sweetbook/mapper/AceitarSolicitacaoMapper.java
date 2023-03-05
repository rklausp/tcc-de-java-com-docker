package br.com.cwi.sweetbook.mapper;

import br.com.cwi.sweetbook.controller.response.AceitarSolicitacaoResponse;
import br.com.cwi.sweetbook.controller.response.EnviarSolicitacaoResponse;
import br.com.cwi.sweetbook.domain.Amizade;

public class AceitarSolicitacaoMapper {

    public static AceitarSolicitacaoResponse toResponse(Amizade amizade) {
        return AceitarSolicitacaoResponse.builder()
                .nomeSolicitante(amizade.getSolicitante().getNomeCompleto())
                .nomeSolicitado(amizade.getSolicitado().getNomeCompleto())
                .situacao(amizade.getSituacao())
                .build();
    }

}
