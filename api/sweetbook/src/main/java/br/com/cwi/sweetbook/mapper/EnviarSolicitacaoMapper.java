package br.com.cwi.sweetbook.mapper;

import br.com.cwi.sweetbook.controller.response.EnviarSolicitacaoResponse;
import br.com.cwi.sweetbook.domain.Amizade;
import br.com.cwi.sweetbook.domain.Situacao;
import br.com.cwi.sweetbook.security.domain.Usuario;

public class EnviarSolicitacaoMapper {
    public static Amizade toEntity() {
        return Amizade.builder()
                .situacao(Situacao.SOLICITADO)
                .disponivelSolicitar(false)
                .build();
    }

    public static EnviarSolicitacaoResponse toResponse(Amizade amizade) {
        return EnviarSolicitacaoResponse.builder()
                .amizadeId(amizade.getId())
                .nomeSolicitante(amizade.getSolicitante().getNomeCompleto())
                .nomeSolicitado(amizade.getSolicitado().getNomeCompleto())
                .situacao(amizade.getSituacao())
                .build();
    }
}
