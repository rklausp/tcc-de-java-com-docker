package br.com.cwi.sweetbook.service.amizades;

import br.com.cwi.sweetbook.controller.response.EnviarSolicitacaoResponse;
import br.com.cwi.sweetbook.domain.Situacao;
import br.com.cwi.sweetbook.mapper.EnviarSolicitacaoMapper;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.service.UsuarioAutenticadoService;
import br.com.cwi.sweetbook.service.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarSolicitacoesService {

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    public List<EnviarSolicitacaoResponse> listar() {

        Long idUsuario = usuarioAutenticadoService.getId();

        Usuario usuario = buscarUsuarioPorIdService.porId(idUsuario);

        return usuario
                .getAmigosDe().stream()
                .filter(amizade -> amizade.getSituacao() == Situacao.SOLICITADO)
                .map(EnviarSolicitacaoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
