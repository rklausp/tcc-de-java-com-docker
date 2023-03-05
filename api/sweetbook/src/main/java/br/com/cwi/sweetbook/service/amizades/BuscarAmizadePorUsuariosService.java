package br.com.cwi.sweetbook.service.amizades;

import br.com.cwi.sweetbook.domain.Amizade;
import br.com.cwi.sweetbook.domain.Situacao;
import br.com.cwi.sweetbook.repository.AmizadeRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BuscarAmizadePorUsuariosService {

    @Autowired
    AmizadeRepository amizadeRepository;

    public Amizade buscar(Usuario eu, Usuario outro) {

        if(amizadeRepository.existsBySolicitanteAndSolicitadoAndSituacao(eu, outro, Situacao.ACEITO))
            return amizadeRepository.findBySolicitanteAndSolicitadoAndSituacao(eu, outro, Situacao.ACEITO);
        else if(amizadeRepository.existsBySolicitanteAndSolicitadoAndSituacao(outro, eu, Situacao.ACEITO))
            return amizadeRepository.findBySolicitanteAndSolicitadoAndSituacao(outro, eu, Situacao.ACEITO);
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Amizade nao encontrada!");

    }
}
