package br.com.cwi.sweetbook.mapper;

import br.com.cwi.sweetbook.controller.request.FazerPostRequest;
import br.com.cwi.sweetbook.controller.response.PostDetalhadoResponse;
import br.com.cwi.sweetbook.domain.Postagem;

import java.time.LocalDateTime;

public class FazerPostMapper {
    public static Postagem toEntity(FazerPostRequest request) {
        return Postagem.builder()
                .texto(request.getTexto())
                .imagemUrl(request.getImagemUrl())
                .tipo(request.getTipo())
                .horaPost(LocalDateTime.now())
                .build();
    }

    public static PostDetalhadoResponse toResponse(Postagem post) {
        return PostDetalhadoResponse.builder()
                .texto(post.getTexto())
                .imagemUrl(post.getImagemUrl())
                .tipo(post.getTipo())
                .horaPost(post.getHoraPost())
                .build();
    }
}
