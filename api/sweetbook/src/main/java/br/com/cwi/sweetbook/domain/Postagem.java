package br.com.cwi.sweetbook.domain;

import br.com.cwi.sweetbook.security.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;
    private String imagemUrl;
    private LocalDateTime horaPost;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @OneToMany(mappedBy = "postagemCurtida")
    List<Curtida> curtidas = new ArrayList<>();

    @OneToMany(mappedBy = "postagemComentada")
    List<Comentario> comentarios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario quemPostou;

    public void serCurtida(Curtida curtida) {
        this.getCurtidas().add(curtida);
        curtida.setPostagemCurtida(this);
    }

    public void serComentada(Comentario comentario) {
        this.getComentarios().add(comentario);
        comentario.setPostagemComentada(this);
    }

    public void removerCurtida(Curtida curtida) {
        this.getComentarios().remove(curtida);
    }
}
