package br.com.cwi.sweetbook.service.verificadores;

import br.com.cwi.sweetbook.security.domain.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VerificaSeUsuariosSaoIguaisService {
    public void verifica(Usuario solicitante, Usuario solicitado) {

        if(solicitante.getId() == solicitado.getId())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nao se pode ter uma amizade consigo mesmo");
    }
}
