package br.com.cwi.sweetbook.service.posts;

import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.repository.PostRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BuscarPostagemPorIdService {

    @Autowired
    PostRepository postRepository;

    public Postagem porId(Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Postagem nao encontrada!"));
    }

}
