package br.com.cwi.sweetbook.factories;

import br.com.cwi.sweetbook.security.domain.Usuario;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class UsuarioFactory {


    public static Usuario getUserOne() {
        return Usuario.builder()
                .id(SimpleFactory.getRandomLong())
                .nomeCompleto("Usuario teste")
                .email("teste@gmail.com")
                .dataNascimento(LocalDate.of(2000, 1, 1))
                .senha("teste")
                .build();
    }

    public static Usuario getUserTwo() {
        return Usuario.builder()
                .id(SimpleFactory.getRandomLong())
                .nomeCompleto("Usuario teste 2")
                .email("teste2@gmail.com")
                .dataNascimento(LocalDate.of(2000, 1, 1))
                .senha("teste")
                .build();
    }

    public static Usuario getUsuarioComPosts() {
        return Usuario.builder()
                .id(SimpleFactory.getRandomLong())
                .nomeCompleto("Usuario teste 2")
                .email("teste2@gmail.com")
                .dataNascimento(LocalDate.of(2000, 1, 1))
                .senha("teste")
                .build();
    }
}
