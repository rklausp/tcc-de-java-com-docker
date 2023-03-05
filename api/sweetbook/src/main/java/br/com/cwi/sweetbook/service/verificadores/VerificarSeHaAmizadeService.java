package br.com.cwi.sweetbook.service.verificadores;

import br.com.cwi.sweetbook.domain.Situacao;
import br.com.cwi.sweetbook.repository.AmizadeRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificarSeHaAmizadeService {

    @Autowired
    AmizadeRepository amizadeRepository;

    public boolean verifica(Usuario eu, Usuario outro) {

        if(amizadeRepository.existsBySolicitanteAndSolicitadoAndSituacao(eu, outro, Situacao.ACEITO)
           || amizadeRepository.existsBySolicitanteAndSolicitadoAndSituacao(outro, eu, Situacao.ACEITO) )
            return true;
        return false;
    }
}
