package br.com.cwi.sweetbook.controller.request;


import br.com.cwi.sweetbook.domain.Tipo;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class FazerPostRequest {

    @NotBlank
    private String texto;

    private String imagemUrl;

    @NotNull
    private Tipo tipo;
}
