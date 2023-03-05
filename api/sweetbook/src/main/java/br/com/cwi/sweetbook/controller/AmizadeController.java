package br.com.cwi.sweetbook.controller;

import br.com.cwi.sweetbook.controller.response.AceitarSolicitacaoResponse;
import br.com.cwi.sweetbook.controller.response.BooleanResponse;
import br.com.cwi.sweetbook.controller.response.EnviarSolicitacaoResponse;
import br.com.cwi.sweetbook.controller.response.UsuarioDetalhadoResponse;
import br.com.cwi.sweetbook.service.amizades.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amizades")
public class AmizadeController {


    @Autowired
    EnviarSolicitacaoService enviarSolicitacaoService;

    @Autowired
    AceitarSolicitacaoService aceitarSolicitacaoService;

    @Autowired
    RemoverRelacaoService removerRelacaoService;

    @Autowired
    BuscarAmizadesService buscarAmizadesService;

    @Autowired
    ListarSolicitacoesService listarSolicitacoesService;

    @Autowired
    BuscarUsuariosAmigosService buscarUsuariosAmigosService;

    @Autowired
    IsAmigoService isAmigoService;

    @PostMapping("{usuarioId}/enviarSolicitacao")
    public EnviarSolicitacaoResponse enviar(@PathVariable Long usuarioId){
        return enviarSolicitacaoService.solicitar(usuarioId);
    }

    @PutMapping("/{amizadeId}/aceitar")
    public AceitarSolicitacaoResponse aceitar(@PathVariable Long amizadeId){
        return aceitarSolicitacaoService.aceitar(amizadeId);
    }

    @DeleteMapping("/{usuarioId}")
    public EnviarSolicitacaoResponse remover(@PathVariable Long usuarioId){
        return removerRelacaoService.remover(usuarioId);
    }

    @GetMapping("/listarAmizades")
    @ResponseBody
    public Page<EnviarSolicitacaoResponse> buscarAmizades(@RequestParam(name = "text") String pesquisa, Pageable pageable){
        return buscarAmizadesService.buscar(pesquisa, pageable);
    }

    @GetMapping("/listarAmigos")
    @ResponseBody
    public Page<UsuarioDetalhadoResponse> buscarUsuariosAmigos(@RequestParam(name = "text") String pesquisa, Pageable pageable){
        return buscarUsuariosAmigosService.buscar(pesquisa, pageable);
    }

    @GetMapping("/solicitacoes")
    public List<EnviarSolicitacaoResponse> verPedidios(){
        return listarSolicitacoesService.listar();
    }

    @GetMapping("/{idUsuario}/isAmigo")
    public BooleanResponse idsAmigos(@PathVariable Long idUsuario){
        return isAmigoService.isAmigo(idUsuario);
    }
}
