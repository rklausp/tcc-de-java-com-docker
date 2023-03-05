
# SWEETBOOK API

A chamadas da api são separadas em 5 controllers: AmizadeController, PerfilController, PostagemController, UsuarioController, LoginController. Geralmente, fazem-se através do usuário autenticado logado.

## Amizade Controller
- Enviar pedido de amizade `POST /amizades/{usuarioId}/enviarSoliciacao`
- Aceitar pedido de amizade `PUT /amizades/{amizadeId}/aceitar`
- Remover relacao com determinzado usuário `DELETE /amizades/{usuarioId}`
- Listar amizades do usuário `GET /amizades/listarAmizades`
- Listar usuários com relação de amizade `GET /amizades/listarAmigos`
- Listar pedididos de amizade `GET /amizades/solicitacoes`
- Retorna se usuario for amigo ou não `GET /amizades/{idUsuario}/isAmigo`

## Perfil Controller
- Detalha usuário especificado `GET /perfil/{usuarioId}`
- Perfil de usuário logado `GET /perfil`
- Alterar perfil `PUT /perfil`
- Buscar usuário paginado `GET /perfil/buscar`

## Postagem Controller
- Fazer post `POST /posts`
- Mostrar posts de usuário `GET /posts/{usuarioId}/posts`
- Mostrar feed `GET /posts/feed`
- Detalhes de post `GET /posts/{postId}`
- Mostrar posts de outro usuário `GET /posts/{usuarioId}/outro`
- Curtir post `POST /posts/{postagemId}/curtir`
- Descurtir post `DELETE /posts/{postagemId}/descurtir`
- Mostar curtidas de post `GET /posts/{postagemId}/curtidas`
- Comentar post `POST /posts/{postagemId}/comentar`
- Mostrar comentarios de post `GET /posts/{postagemId}/comentarios`

## Usuario Controller
- Incluir Usuário `POST /usuarios`
- Meu usuário `GET /usuarios/me`

## Login Controller
- Fazer login `POST /login`

