package br.com.cwi.sweetbook.service.amizades;

import br.com.cwi.sweetbook.domain.Amizade;
import br.com.cwi.sweetbook.domain.Situacao;
import br.com.cwi.sweetbook.repository.AmizadeRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarAmigosService {

    @Autowired
    AmizadeRepository amizadeRepository;


    public List<Usuario> listarAmigos(Usuario usuario){
        List<Amizade> relacoesAmizade = amizadeRepository.findByAmizades(usuario, Situacao.ACEITO);

        return relacoesAmizade.stream().map(amizade -> {
            if(amizade.getSolicitado() == usuario)
                return amizade.getSolicitante();
            return amizade.getSolicitado();
        }).collect(Collectors.toList());
    }
}
