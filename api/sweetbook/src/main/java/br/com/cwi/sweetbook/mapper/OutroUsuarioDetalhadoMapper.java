package br.com.cwi.sweetbook.mapper;

import br.com.cwi.sweetbook.controller.response.OutroUsuarioDetalhadoResponse;
import br.com.cwi.sweetbook.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.sweetbook.security.domain.Usuario;

public class OutroUsuarioDetalhadoMapper {


    public static OutroUsuarioDetalhadoResponse toResponse(Usuario usuario, boolean isAmigo) {
        return OutroUsuarioDetalhadoResponse.builder()
                .id(usuario.getId())
                .nomeCompleto(usuario.getNomeCompleto())
                .email(usuario.getEmail())
                .apelido(usuario.getApelido())
                .dataNascimento(usuario.getDataNascimento())
                .imagemPerfil(usuario.getImagemPerfil())
                .isAmigo(isAmigo)
                .build();
    }
}
