package br.com.cwi.sweetbook.controller;


import br.com.cwi.sweetbook.controller.request.ComentarPostRequest;
import br.com.cwi.sweetbook.controller.request.FazerPostRequest;
import br.com.cwi.sweetbook.controller.response.ComentarioResponse;
import br.com.cwi.sweetbook.controller.response.CurtidasResponse;
import br.com.cwi.sweetbook.controller.response.PostDetalhadoResponse;
import br.com.cwi.sweetbook.service.posts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostagemController {


    @Autowired
    FazerPostService fazerPostService;

    @Autowired
    MostrarPostsUsuarioService mostrarPostsUsuarioService;

    @Autowired
    MostrarPostsOutroUsuarioService mostrarPostsOutroUsuarioService;

    @Autowired
    CurtirPostService curtirPostService;

    @Autowired
    MostrarCurtidasService mostrarCurtidasService;

    @Autowired
    ComentarPostService comentarPostService;

    @Autowired
    MostrarComentariosService mostrarComentariosService;

    @Autowired
    RemoverCurtirPostService removerCurtirPostService;

    @Autowired
    MostrarFeedService mostrarFeedService;

    @Autowired
    DetalharPostService detalharPostService;

    @PostMapping
    public PostDetalhadoResponse fazerPost(@Valid @RequestBody FazerPostRequest request){
        return fazerPostService.postar(request);
    }

    @GetMapping("/{usuarioId}/posts")
    public Page<PostDetalhadoResponse> mostrarPostsDeUsuario(@PathVariable Long usuarioId, Pageable pageable){
        return mostrarPostsUsuarioService.mostrar(usuarioId, pageable);
    }

    @GetMapping("/feed")
    public Page<PostDetalhadoResponse> mostrarFeed(Pageable pageable){
        return mostrarFeedService.mostrar(pageable);
    }

    @GetMapping("/{postId}")
    public PostDetalhadoResponse postDestalhado(@PathVariable Long postId){
        return detalharPostService.detalhar(postId);
    }

    @GetMapping("/{usuarioId}/outro")
    public Page<PostDetalhadoResponse> mostrarPosts(@PathVariable Long usuarioId, Pageable pageable) {
        return mostrarPostsOutroUsuarioService.mostrar(usuarioId, pageable);
    }

    @PostMapping("/{postagemId}/curtir")
    @ResponseStatus(HttpStatus.OK)
    public void curtirPost(@PathVariable Long postagemId){
        curtirPostService.curtir(postagemId);
    }

    @DeleteMapping("/{postagemId}/descurtir")
    @ResponseStatus(HttpStatus.OK)
    public void removerCurtirPost(@PathVariable Long postagemId){
        removerCurtirPostService.removerCurtir(postagemId);
    }


    @GetMapping("/{postagemId}/curtidas")
    public List<CurtidasResponse> mostrarCurtidas(@PathVariable Long postagemId){
        return mostrarCurtidasService.mostrar(postagemId);
    }

    @PostMapping("/{postagemId}/comentar")
    public void comentarPost(@PathVariable Long postagemId, @Valid @RequestBody ComentarPostRequest request){
        comentarPostService.comentar(postagemId, request);
    }

    @GetMapping("/{postagemId}/comentarios")
    public List<ComentarioResponse> mostrarComentarios(@PathVariable Long postagemId){
        return mostrarComentariosService.mostar(postagemId);
    }
}
