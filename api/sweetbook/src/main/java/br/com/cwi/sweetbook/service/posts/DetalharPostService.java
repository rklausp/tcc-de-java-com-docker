package br.com.cwi.sweetbook.service.posts;

import br.com.cwi.sweetbook.controller.response.PostDetalhadoResponse;
import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.mapper.PostDetalhadoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalharPostService {

    @Autowired
    BuscarPostagemPorIdService buscarPostagemPorIdService;

    public PostDetalhadoResponse detalhar(Long id) {

        Postagem post = buscarPostagemPorIdService.porId(id);

        return PostDetalhadoMapper.toResponse(post);
    }
}
