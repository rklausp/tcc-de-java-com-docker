package br.com.cwi.sweetbook.controller.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ComentarioResponse {

    private Long idUsuario;
    private String nomeUsuario;
    private String texto;

}
