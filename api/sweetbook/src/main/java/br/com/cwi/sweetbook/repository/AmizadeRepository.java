package br.com.cwi.sweetbook.repository;

import br.com.cwi.sweetbook.domain.Amizade;
import br.com.cwi.sweetbook.domain.Situacao;
import br.com.cwi.sweetbook.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface    AmizadeRepository extends JpaRepository<Amizade, Long> {

    boolean existsBySolicitanteAndSolicitadoAndDisponivelSolicitar(Usuario usuarioUm, Usuario usuarioDois, boolean disponivel);

    //Page<Amizade> findBySolicitanteIdOrSolicitadoId(Long idUsuario, Long idUsuarioDois, Pageable pageable);

    @Query("select a FROM Amizade a WHERE ((a.solicitante = :usuario or a.solicitado = :usuario) and (a.situacao = :situacao)) and ((LOWER(a.solicitado.nomeCompleto) like %:pesquisa% or LOWER(a.solicitado.email) like %:pesquisa%) or (LOWER(a.solicitante.nomeCompleto) like %:pesquisa%) or LOWER(a.solicitante.email) like %:pesquisa%)")
    Page<Amizade> findByAmizadesAtivas(Usuario usuario, String pesquisa, Situacao situacao, Pageable pageable);

    @Query("select a FROM Amizade a WHERE ((a.solicitante = :usuario or a.solicitado = :usuario) and (a.situacao = :situacao))")
    List<Amizade> findByAmizades(Usuario usuario, Situacao situacao);

    boolean existsBySolicitanteAndSolicitadoAndSituacao(Usuario eu, Usuario outro, Situacao aceito);

    Amizade findBySolicitanteAndSolicitadoAndSituacao(Usuario eu, Usuario outro, Situacao aceito);
}
