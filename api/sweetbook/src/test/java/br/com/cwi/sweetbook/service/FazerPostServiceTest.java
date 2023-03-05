package br.com.cwi.sweetbook.service;

import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.repository.PostRepository;
import br.com.cwi.sweetbook.security.service.UsuarioAutenticadoService;
import br.com.cwi.sweetbook.service.posts.FazerPostService;
import br.com.cwi.sweetbook.service.usuario.BuscarUsuarioPorIdService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FazerPostServiceTest {

    @InjectMocks
    private FazerPostService tested;

    @Mock
    BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Mock
    PostRepository postRepository;

    @Mock
    UsuarioAutenticadoService usuarioAutenticadoService;

    @Captor
    private ArgumentCaptor<Postagem> postagemCaptor;

    /*
    @Test
    @DisplayName("Deve fazer post publico novo com sucesso")
    void deveFazerPostNovoComSucesso() {
        FazerPostRequest request = new FazerPostRequest();
        Usuario usuario = UsuarioFactory.getUserOne();
        request.setTexto("post test");
        request.setTipo(Tipo.PUBLICO);

        when(usuarioAutenticadoService.getId()).thenReturn(usuario.getId());
        when(buscarUsuarioPorIdService.porId(usuario.getId())).thenReturn(usuario);
        when(usuario.fazerPost(postagemCaptor.getValue()).thenReturn();

        tested.postar(request);

        verify(postRepository).save(postagemCaptor.getValue());
        Postagem post = postagemCaptor.getValue();

        assertEquals("post test", post.getTexto());
        assertEquals(Tipo.PUBLICO, post.getTipo());
        assertEquals(usuario, post.getQuemPostou());

    }
     */
}
