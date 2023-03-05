package br.com.cwi.sweetbook.mapper;


import br.com.cwi.sweetbook.controller.response.PostDetalhadoResponse;
import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.factories.PostagemFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FazerPostMapperTest {

    @Test
    @DisplayName("Deve retornar response completo quando request completo")
    void deveRetornarResponseCompletoQuandoRequestCompleto() {

        Postagem post = PostagemFactory.getPostagemPrivada();

        PostDetalhadoResponse response = FazerPostMapper.toResponse(post);

        assertEquals(post.getTexto(), response.getTexto());
        assertEquals(post.getImagemUrl(), response.getImagemUrl());
        assertEquals(post.getTipo(), response.getTipo());
        assertEquals(post.getTipo(), response.getTipo());
        assertEquals(post.getHoraPost(), response.getHoraPost());
    }
}
