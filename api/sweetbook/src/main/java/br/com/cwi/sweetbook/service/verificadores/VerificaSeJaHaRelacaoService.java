package br.com.cwi.sweetbook.service.verificadores;

import br.com.cwi.sweetbook.repository.AmizadeRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VerificaSeJaHaRelacaoService {

    @Autowired
    AmizadeRepository amizadeRepository;

    public void verifica(Usuario solicitante, Usuario solicitado) {

        boolean validacaoUm = (amizadeRepository.existsBySolicitanteAndSolicitadoAndDisponivelSolicitar(solicitante, solicitado, false));
        boolean validacaoDois = (amizadeRepository.existsBySolicitanteAndSolicitadoAndDisponivelSolicitar(solicitado, solicitante, false));

        if(validacaoUm || validacaoDois)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ja possum relacao");


    }
}
