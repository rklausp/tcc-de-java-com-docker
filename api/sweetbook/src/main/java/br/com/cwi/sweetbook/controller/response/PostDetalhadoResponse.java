package br.com.cwi.sweetbook.controller.response;


import br.com.cwi.sweetbook.domain.Comentario;
import br.com.cwi.sweetbook.domain.Curtida;
import br.com.cwi.sweetbook.domain.Tipo;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDetalhadoResponse {

    private Long id;
    private String usuarioNome;
    private Long usuarioId;
    private String texto;
    private String imagemUrl;
    private Tipo tipo;
    private LocalDateTime horaPost;
}
