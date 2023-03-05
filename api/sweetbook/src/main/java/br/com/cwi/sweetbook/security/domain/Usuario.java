package br.com.cwi.sweetbook.security.domain;

import br.com.cwi.sweetbook.domain.Amizade;
import br.com.cwi.sweetbook.domain.Comentario;
import br.com.cwi.sweetbook.domain.Curtida;
import br.com.cwi.sweetbook.domain.Postagem;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String email;
    private String apelido;
    private String senha;
    private String imagemPerfil;
    private boolean ativo;


    @OneToMany(mappedBy = "quemCurtiu")
    List<Curtida> postsCurtidos = new ArrayList<>();

    @OneToMany(mappedBy = "quemComentou")
    List<Comentario> comentariosNosPosts = new ArrayList<>();

    @OneToMany(mappedBy = "quemPostou")
    private List<Postagem> postagens = new ArrayList<>();

    @OneToMany(mappedBy = "solicitante")
    private List<Amizade> amigos = new ArrayList<>();

    @OneToMany(mappedBy = "solicitado")
    private List<Amizade> amigosDe = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();


    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }

    public void fazerPost(Postagem post) {
        this.getPostagens().add(post);
        post.setQuemPostou(this);
    }

    public void curtir(Curtida curtida) {
        this.getPostsCurtidos().add(curtida);
        curtida.setQuemCurtiu(this);
    }

    public void comentar(Comentario comentario) {
        this.getComentariosNosPosts().add(comentario);
        comentario.setQuemComentou(this);
    }

    public void removerCurtida(Curtida curtida) {
        this.getPostsCurtidos().remove(curtida);
    }

    public void enviarSolicitacao(Amizade amizade) {
        this.getAmigos().add(amizade);
        amizade.setSolicitante(this);
    }

    public void receberSolicitacao(Amizade amizade) {
        this.getAmigosDe().add(amizade);
        amizade.setSolicitado(this);
    }

}
