package br.com.cwi.sweetbook.controller.response;

import br.com.cwi.sweetbook.domain.Situacao;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EnviarSolicitacaoResponse {

    private Long amizadeId;
    private String nomeSolicitante;
    private String nomeSolicitado;
    private Situacao situacao;
}
