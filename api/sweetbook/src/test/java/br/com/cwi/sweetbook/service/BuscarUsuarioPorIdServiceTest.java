package br.com.cwi.sweetbook.service;


import br.com.cwi.sweetbook.factories.SimpleFactory;
import br.com.cwi.sweetbook.factories.UsuarioFactory;
import br.com.cwi.sweetbook.security.domain.Usuario;
import br.com.cwi.sweetbook.security.repository.UsuarioRepository;
import br.com.cwi.sweetbook.service.usuario.BuscarUsuarioPorIdService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class BuscarUsuarioPorIdServiceTest {

    @InjectMocks
    BuscarUsuarioPorIdService tested;

    @Mock
    UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Deve retornar usuario por seu id")
    void deveRetornarUsuarioPorSeuId(){

        Usuario usuario = UsuarioFactory.getUserOne();

        when(usuarioRepository.findById(usuario.getId())).thenReturn(Optional.of(usuario));

        Usuario user = tested.porId(usuario.getId());

        assertEquals(user, usuario);
    }

    @Test
    @DisplayName("Deve dar erro ao procurar id por id inexistente")
    void deveDarErroAoProcurarPorIdInexiste(){

        Long id = SimpleFactory.getRandomLong();

        assertThrows(ResponseStatusException.class, () -> {
            tested.porId(id);
        });
    }
}
