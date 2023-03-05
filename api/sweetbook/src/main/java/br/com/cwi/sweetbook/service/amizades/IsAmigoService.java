package br.com.cwi.sweetbook.service.amizades;

import br.com.cwi.sweetbook.controller.response.BooleanResponse;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.service.UsuarioAutenticadoService;
import br.com.cwi.sweetbook.service.usuario.BuscarUsuarioPorIdService;
import br.com.cwi.sweetbook.service.verificadores.VerificarSeHaAmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IsAmigoService {

    @Autowired
    VerificarSeHaAmizadeService verificarSeHaAmizadeService;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    public BooleanResponse isAmigo(Long idUsuario) {

        Long idEu =  usuarioAutenticadoService.getId();
        Usuario eu = buscarUsuarioPorIdService.porId(idEu);
        Usuario outro = buscarUsuarioPorIdService.porId(idUsuario);

        boolean amizade = verificarSeHaAmizadeService.verifica(eu, outro);

        BooleanResponse isAmigo = new BooleanResponse();
        isAmigo.setAmigo(amizade);

        return isAmigo;
    }
}
