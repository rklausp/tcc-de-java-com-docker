package br.com.cwi.sweetbook.factories;

import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.domain.Tipo;
import br.com.cwi.sweetbook.security.domain.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class PostagemFactory {

    public static Postagem getPostagemPublica() {
        return Postagem.builder()
                .id(SimpleFactory.getRandomLong())
                .texto("post texte")
                .tipo(Tipo.PUBLICO)
                .imagemUrl("www")
                .horaPost(LocalDateTime.of(2017, Month.FEBRUARY,3,6,30,40,50000))
                .build();
    }

    public static Postagem getPostagemPrivada() {
        return Postagem.builder()
                .id(SimpleFactory.getRandomLong())
                .texto("post texte")
                .tipo(Tipo.PRIVADO)
                .build();
    }
}
