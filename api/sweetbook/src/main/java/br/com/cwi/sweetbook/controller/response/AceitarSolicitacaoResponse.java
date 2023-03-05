package br.com.cwi.sweetbook.controller.response;

import br.com.cwi.sweetbook.domain.Situacao;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AceitarSolicitacaoResponse {

    private String nomeSolicitante;
    private String nomeSolicitado;
    private Situacao situacao;

}
