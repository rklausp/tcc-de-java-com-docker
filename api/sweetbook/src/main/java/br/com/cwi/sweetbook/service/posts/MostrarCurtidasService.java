package br.com.cwi.sweetbook.service.posts;

import br.com.cwi.sweetbook.controller.response.CurtidasResponse;
import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.mapper.CurtidasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MostrarCurtidasService {

    @Autowired
    BuscarPostagemPorIdService buscarPostagemPorIdService;



    public List<CurtidasResponse> mostrar(Long postagemId) {

        Postagem postagem = buscarPostagemPorIdService.porId(postagemId);

        return postagem.getCurtidas().stream()
                .map(CurtidasMapper::toResponse)
                .collect(Collectors.toList());

    }
}
