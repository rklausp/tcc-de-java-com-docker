package br.com.cwi.sweetbook.controller.response;

import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.security.domain.Usuario;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDetalhadoResponse {

    private Long id;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String email;
    private String apelido;
    private String imagemPerfil;
}
