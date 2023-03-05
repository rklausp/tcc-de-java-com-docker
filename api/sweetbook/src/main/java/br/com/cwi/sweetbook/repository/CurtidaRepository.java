package br.com.cwi.sweetbook.repository;

import br.com.cwi.sweetbook.domain.Curtida;
import br.com.cwi.sweetbook.domain.Postagem;
import br.com.cwi.sweetbook.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurtidaRepository extends JpaRepository<Curtida, Long> {
    Curtida findByPostagemCurtidaAndQuemCurtiu(Postagem postagem, Usuario usuario);
}
