package br.com.cwi.sweetbook.domain;

import br.com.cwi.sweetbook.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    @ManyToOne
    @JoinColumn(name = "postagem_id")
    private Postagem postagemComentada;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario quemComentou;
}
