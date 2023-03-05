package br.com.cwi.sweetbook.service.usuario;

import br.com.cwi.sweetbook.controller.request.AlterarUsuarioRequest;
import br.com.cwi.sweetbook.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.sweetbook.mapper.UsuarioDetalhadoMapper;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.repository.UsuarioRepository;
import br.com.cwi.sweetbook.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlterarUsuarioService {

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    UsuarioRepository usuarioRepository;
    @Transactional
    public UsuarioDetalhadoResponse alterar(AlterarUsuarioRequest request) {

        Long usuarioId = usuarioAutenticadoService.getId();
        Usuario usuario = buscarUsuarioPorIdService.porId(usuarioId);

        if(request.getApelido() != null && !request.getApelido().isEmpty())
            usuario.setApelido(request.getApelido());

        if(request.getImagem() != null && !request.getImagem().isEmpty())
            usuario.setImagemPerfil(request.getImagem());

        if(request.getNomeCompleto() != null && !request.getNomeCompleto().isEmpty())
            usuario.setNomeCompleto(request.getNomeCompleto());

        usuarioRepository.save(usuario);

        return UsuarioDetalhadoMapper.toResponse(usuario);
    }
}
