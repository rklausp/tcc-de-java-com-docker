package br.com.cwi.sweetbook.mapper;

import br.com.cwi.sweetbook.controller.response.PostDetalhadoResponse;
import br.com.cwi.sweetbook.domain.Postagem;

public class PostDetalhadoMapper {

    public static PostDetalhadoResponse toResponse(Postagem post) {
        PostDetalhadoResponse response = new PostDetalhadoResponse();
        response.setTexto(post.getTexto());
        response.setId(post.getId());
        response.setUsuarioNome(post.getQuemPostou().getNomeCompleto());
        response.setUsuarioId(post.getQuemPostou().getId());
        response.setImagemUrl(post.getImagemUrl());
        response.setTipo(post.getTipo());
        response.setHoraPost(post.getHoraPost());
        return response;
    }
}
