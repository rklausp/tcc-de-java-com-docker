package br.com.cwi.sweetbook.security.controller;

import br.com.cwi.sweetbook.security.controller.response.UsuarioResponse;
import br.com.cwi.sweetbook.security.service.BuscarUsuarioService;
import br.com.cwi.sweetbook.security.controller.response.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @PostMapping
    public UsuarioResponse login() {
        return buscarUsuarioService.buscar();
    }
}

