package br.com.cwi.sweetbook.mapper;

import br.com.cwi.sweetbook.controller.response.ComentarioResponse;
import br.com.cwi.sweetbook.domain.Comentario;

public class ComentariosMapper {
    public static ComentarioResponse toResponse(Comentario comentario) {
        return ComentarioResponse.builder()
                .idUsuario(comentario.getQuemComentou().getId())
                .nomeUsuario(comentario.getQuemComentou().getNomeCompleto())
                .texto(comentario.getTexto())
                .build();
    }
}
