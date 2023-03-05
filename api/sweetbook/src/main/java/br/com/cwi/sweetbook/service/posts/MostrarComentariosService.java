package br.com.cwi.sweetbook.service.posts;

import br.com.cwi.sweetbook.controller.response.ComentarioResponse;
import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.mapper.ComentariosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MostrarComentariosService {

    @Autowired
    BuscarPostagemPorIdService buscarPostagemPorIdService;
    public List<ComentarioResponse> mostar(Long postagemId) {

        Postagem postagem = buscarPostagemPorIdService.porId(postagemId);

        return postagem.getComentarios().stream()
                .map(ComentariosMapper::toResponse)
                .collect(Collectors.toList());

    }
}
