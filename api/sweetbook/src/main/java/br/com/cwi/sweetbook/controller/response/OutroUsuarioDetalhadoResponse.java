package br.com.cwi.sweetbook.controller.response;

import lombok.*;

import java.time.LocalDate;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OutroUsuarioDetalhadoResponse {

    private Long id;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String email;
    private String apelido;
    private String imagemPerfil;
    private boolean isAmigo;
}
