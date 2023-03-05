package br.com.cwi.sweetbook.domain;

import br.com.cwi.sweetbook.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class Amizade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean disponivelSolicitar;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @ManyToOne
    @JoinColumn(name = "usuario_um_id")
    private Usuario solicitante;

    @ManyToOne
    @JoinColumn(name = "usuario_dois_id")
    private Usuario solicitado;
}
