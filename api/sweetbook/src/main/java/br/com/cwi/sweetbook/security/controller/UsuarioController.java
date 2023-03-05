package br.com.cwi.sweetbook.security.controller;

import br.com.cwi.sweetbook.security.controller.request.UsuarioRequest;
import br.com.cwi.sweetbook.security.controller.response.UsuarioResponse;
import br.com.cwi.sweetbook.security.service.BuscarUsuarioService;
import br.com.cwi.sweetbook.security.service.IncluirUsuarioService;
import br.com.cwi.sweetbook.security.controller.request.UsuarioRequest;
import br.com.cwi.sweetbook.security.controller.response.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IncluirUsuarioService incluirUsuarioService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @PostMapping
    public UsuarioResponse incluir(@Valid @RequestBody UsuarioRequest request) {
        return incluirUsuarioService.incluir(request);
    }

    @GetMapping("/me")
    public UsuarioResponse buscar() {
        return buscarUsuarioService.buscar();
    }
}

