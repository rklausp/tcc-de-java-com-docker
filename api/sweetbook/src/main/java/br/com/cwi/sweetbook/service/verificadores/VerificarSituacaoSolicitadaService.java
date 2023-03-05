package br.com.cwi.sweetbook.service.verificadores;

import br.com.cwi.sweetbook.domain.Amizade;
import br.com.cwi.sweetbook.domain.Situacao;
import br.com.cwi.sweetbook.repository.AmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VerificarSituacaoSolicitadaService {

    @Autowired
    AmizadeRepository amizadeRepository;


    public void verificar(Amizade amizade) {
        if(amizade.getSituacao() != Situacao.SOLICITADO)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Amizade nao esta na fase de solicitacao");
    }
}
