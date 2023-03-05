package br.com.cwi.sweetbook.mapper;

import br.com.cwi.sweetbook.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.sweetbook.security.domain.Usuario;

public class UsuarioDetalhadoMapper {

    public static UsuarioDetalhadoResponse toResponse(Usuario usuario){
        return UsuarioDetalhadoResponse.builder()
                .id(usuario.getId())
                .nomeCompleto(usuario.getNomeCompleto())
                .email(usuario.getEmail())
                .apelido(usuario.getApelido())
                .dataNascimento(usuario.getDataNascimento())
                .imagemPerfil(usuario.getImagemPerfil())
                .build();
    }
}
