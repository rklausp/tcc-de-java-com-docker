package br.com.cwi.sweetbook.mapper;

import br.com.cwi.sweetbook.controller.request.ComentarPostRequest;
import br.com.cwi.sweetbook.domain.Comentario;

public class FazerComentarioMapper {


    public static Comentario toEntity(ComentarPostRequest request) {
        return Comentario.builder()
                .texto(request.getTexto())
                .build();
    }
}
