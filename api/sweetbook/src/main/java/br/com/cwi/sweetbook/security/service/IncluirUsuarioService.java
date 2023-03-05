package br.com.cwi.sweetbook.security.service;
import br.com.cwi.sweetbook.security.controller.request.UsuarioRequest;
import br.com.cwi.sweetbook.security.controller.response.UsuarioResponse;
import br.com.cwi.sweetbook.security.domain.Permissao;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static br.com.cwi.sweetbook.security.mapper.UsuarioMapper.toEntity;
import static br.com.cwi.sweetbook.security.mapper.UsuarioMapper.toResponse;

@Service
public class IncluirUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioResponse incluir(UsuarioRequest request) {

        Usuario usuario = toEntity(request);
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        usuario.setAtivo(true);

        request.getPermissoes()
                .forEach(p -> usuario.adicionarPermissao(Permissao.builder().nome(p).build()));

        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }
}
