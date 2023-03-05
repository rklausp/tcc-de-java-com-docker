package br.com.cwi.sweetbook.service.amizades;

import br.com.cwi.sweetbook.controller.response.EnviarSolicitacaoResponse;
import br.com.cwi.sweetbook.domain.Situacao;
import br.com.cwi.sweetbook.mapper.EnviarSolicitacaoMapper;
import br.com.cwi.sweetbook.repository.AmizadeRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.service.UsuarioAutenticadoService;
import br.com.cwi.sweetbook.service.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarAmizadesService {


    @Autowired
    AmizadeRepository amizadeRepository;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;
    public Page<EnviarSolicitacaoResponse> buscar(String pesquisa, Pageable pageable) {

        Long idUsuario = usuarioAutenticadoService.getId();
        Usuario usuario = buscarUsuarioPorIdService.porId(idUsuario);

       return amizadeRepository.findByAmizadesAtivas(usuario, pesquisa, Situacao.ACEITO, pageable)
            .map(EnviarSolicitacaoMapper::toResponse);


    }
}
