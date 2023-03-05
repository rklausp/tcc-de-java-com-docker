package br.com.cwi.sweetbook.security.repository;

import br.com.cwi.sweetbook.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.sweetbook.domain.Amizade;
import br.com.cwi.sweetbook.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Page<Usuario> findByNomeCompletoContainingIgnoreCase(String pesquisa, Pageable pageable);

    @Query("Select distinct u from Usuario u where u IN :amigos and (lower(u.nomeCompleto) like %:pesquisa% or lower(u.email) like %:pesquisa%)")
    Page<Usuario> findUsuarios(List<Usuario> amigos, String pesquisa, Pageable pageable);
}
