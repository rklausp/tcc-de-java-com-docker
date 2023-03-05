package br.com.cwi.sweetbook.security.mapper;

import br.com.cwi.sweetbook.security.controller.request.UsuarioRequest;
import br.com.cwi.sweetbook.security.controller.response.UsuarioResponse;
import br.com.cwi.sweetbook.security.domain.Permissao;
import br.com.cwi.sweetbook.security.domain.Usuario;


import java.util.List;

import static java.util.stream.Collectors.toList;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequest request) {
        Usuario entity = new Usuario();
        entity.setNomeCompleto(request.getNomeCompleto());
        entity.setEmail(request.getEmail());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setApelido(request.getApelido());
        entity.setImagemPerfil(request.getImagemPerfil());
        return entity;
    }

    public static UsuarioResponse toResponse(Usuario entity) {
        return UsuarioResponse.builder()
                .nome(entity.getNomeCompleto())
                .email(entity.getEmail())
                .permissoes(buildPermissoesResponse(entity.getPermissoes()))
                .build();
    }

    private static List<String> buildPermissoesResponse(List<Permissao> permissoes) {
        return permissoes.stream()
                .map(Permissao::getNome)
                .collect(toList());
    }
}

