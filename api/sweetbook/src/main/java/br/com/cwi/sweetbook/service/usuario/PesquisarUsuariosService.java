package br.com.cwi.sweetbook.service.usuario;

import br.com.cwi.sweetbook.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.sweetbook.mapper.UsuarioDetalhadoMapper;
import br.com.cwi.sweetbook.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PesquisarUsuariosService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Page<UsuarioDetalhadoResponse> buscar(String pesquisa, Pageable pageable) {

        return usuarioRepository.findByNomeCompletoContainingIgnoreCase(pesquisa, pageable)
                .map(UsuarioDetalhadoMapper::toResponse);
    }
}
