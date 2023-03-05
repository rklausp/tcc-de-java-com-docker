package br.com.cwi.sweetbook.mapper;


import br.com.cwi.sweetbook.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.sweetbook.factories.UsuarioFactory;
import br.com.cwi.sweetbook.security.domain.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UsuarioDetalhadoMapperTest {

    @Test
    @DisplayName("Deve retornar usuario completo quando request completo")
    void deveRetornarResponseCompletoQuandoRequestCompleto() {

        Usuario usuario = UsuarioFactory.getUserOne();

        UsuarioDetalhadoResponse response = UsuarioDetalhadoMapper.toResponse(usuario);

        assertEquals(usuario.getId(), response.getId());
        assertEquals(usuario.getNomeCompleto(), response.getNomeCompleto());
        assertEquals(usuario.getEmail(), response.getEmail());
        assertEquals(usuario.getApelido(), response.getApelido());
        assertEquals(usuario.getDataNascimento(), response.getDataNascimento());
        assertEquals(usuario.getImagemPerfil(), response.getImagemPerfil());

    }
}
