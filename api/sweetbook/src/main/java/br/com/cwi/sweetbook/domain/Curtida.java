package br.com.cwi.sweetbook.domain;

import br.com.cwi.sweetbook.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class Curtida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "postagem_id")
    private Postagem postagemCurtida;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario quemCurtiu;


}
