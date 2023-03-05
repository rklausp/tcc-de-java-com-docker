package br.com.cwi.sweetbook.repository;

import br.com.cwi.sweetbook.controller.response.PostDetalhadoResponse;
import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.domain.Tipo;
import br.com.cwi.sweetbook.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Postagem, Long> {
    Page<Postagem> findByQuemPostou(Usuario usuario, Pageable pageable);

    Page<Postagem> findByQuemPostouAndTipo(Usuario outro, Tipo publico, Pageable pageable);

    @Query("Select p from Postagem p join p.quemPostou q where q IN :amigos")
    Page<Postagem> findPostsParaAparecer(List<Usuario> amigos, Pageable pageable);
}
