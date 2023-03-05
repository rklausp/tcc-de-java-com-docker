package br.com.cwi.sweetbook.service;


import br.com.cwi.sweetbook.controller.response.PostDetalhadoResponse;
import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.factories.PostagemFactory;
import br.com.cwi.sweetbook.factories.UsuarioFactory;
import br.com.cwi.sweetbook.repository.PostRepository;
import br.com.cwi.sweetbook.security.domain.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MostrarPostsUsuarioServiceTest {

    /*
    @InjectMocks
    MostrarPostsUsuarioService tested;

    @Mock
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Mock
    PostRepository postRepository;

    @Test
    @DisplayName("Deve retornar posts do usuario")
    void deveRetornarPostsUsuario(){

        Usuario usuario = UsuarioFactory.getUserOne();
        List<Postagem> posts = new ArrayList<>();
        posts.add(PostagemFactory.getPostagemPublica());
        usuario.setPostagens(posts);
        Page<Postagem> postagemUsuario = new PageImpl<>(usuario.getPostagens());

        when(buscarUsuarioPorIdService.porId(usuario.getId())).thenReturn(usuario);
        Pageable pageable = PageRequest.of(0, 5);
        when(postRepository.findByQuemPostou(usuario, pageable)).thenReturn(postagemUsuario);

        Page<PostDetalhadoResponse> response = tested.mostrar(usuario.getId(), pageable);

        verify(postRepository.findByQuemPostou(usuario, pageable));
        assertEquals(usuario.getPostagens().size(), response.getSize());
        assertEquals(usuario.getPostagens().get(0), response.getContent().get(1));

    }
     */
}
