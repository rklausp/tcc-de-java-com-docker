package br.com.cwi.sweetbook.repository;

import br.com.cwi.sweetbook.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
