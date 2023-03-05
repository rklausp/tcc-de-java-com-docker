package br.com.cwi.sweetbook.controller.response;

import br.com.cwi.sweetbook.security.domain.Usuario;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurtidasResponse {

    private Long idUsuario;
    private String nomeUsuario;

}
