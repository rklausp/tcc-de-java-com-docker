package br.com.cwi.sweetbook.service.amizades;

import br.com.cwi.sweetbook.domain.Amizade;
import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.repository.AmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BuscarAmizadePorIdService {

    @Autowired
    AmizadeRepository amizadeRepository;

    public Amizade porId(Long id){
        return amizadeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Amizade nao encontrada!"));
    }
}
