package br.com.cwi.sweetbook.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class ComentarPostRequest {

    @NotBlank
    private String texto;
}
