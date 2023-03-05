package br.com.cwi.sweetbook.mapper;

import br.com.cwi.sweetbook.controller.response.CurtidasResponse;
import br.com.cwi.sweetbook.domain.Curtida;

public class CurtidasMapper {
    public static CurtidasResponse toResponse(Curtida curtida) {
        return CurtidasResponse.builder()
                .idUsuario(curtida.getQuemCurtiu().getId())
                .nomeUsuario(curtida.getQuemCurtiu().getNomeCompleto())
                .build();
    }
}
