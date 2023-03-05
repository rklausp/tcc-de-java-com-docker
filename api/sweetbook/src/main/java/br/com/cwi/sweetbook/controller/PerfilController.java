package br.com.cwi.sweetbook.controller;


import br.com.cwi.sweetbook.controller.request.AlterarUsuarioRequest;
import br.com.cwi.sweetbook.controller.response.OutroUsuarioDetalhadoResponse;
import br.com.cwi.sweetbook.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.sweetbook.service.usuario.AlterarUsuarioService;
import br.com.cwi.sweetbook.service.usuario.DetalharUsuarioService;
import br.com.cwi.sweetbook.service.usuario.MeuPerfilService;
import br.com.cwi.sweetbook.service.usuario.PesquisarUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    DetalharUsuarioService detalharUsuarioService;

    @Autowired
    AlterarUsuarioService alterarUsuarioService;

    @Autowired
    MeuPerfilService meuPerfilService;

    @Autowired
    PesquisarUsuariosService pesquisarUsuariosService;




    @GetMapping("/{usuarioId}")
    public OutroUsuarioDetalhadoResponse detalharUsuario(@PathVariable Long usuarioId){
        return detalharUsuarioService.detalhar(usuarioId);
    }

    @GetMapping
    public UsuarioDetalhadoResponse meuPerfil(){
        return meuPerfilService.detalhar();
    }

    @PutMapping
    public UsuarioDetalhadoResponse alterarUsuario(@Valid @RequestBody AlterarUsuarioRequest request){
        return alterarUsuarioService.alterar(request);
    }

    @GetMapping("/buscar")
    @ResponseBody
    public Page<UsuarioDetalhadoResponse> buscarUsuarios(@RequestParam(name = "text") String pesquisa, Pageable pageable){
        return pesquisarUsuariosService.buscar(pesquisa, pageable);
    }
}
