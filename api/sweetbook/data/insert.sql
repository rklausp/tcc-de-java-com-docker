

insert into usuario (email, nome_completo, senha, ativo, data_nascimento, apelido, imagem_perfil) values ('silva@cwi.com.br', 'Silva Silva', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', true, '2000-01-01', 'Sil', 'https://this-person-does-not-exist.com/img/avatar-11725bb90d270b28e26aba3e9532a4ee.jpg');
insert into usuario (email, nome_completo, senha, ativo, data_nascimento, apelido, imagem_perfil) values ('santos@cwi.com.br', 'Santos Santos', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', true, '2000-01-01', 'San', 'https://this-person-does-not-exist.com/img/avatar-1115bbe27cb3e64aec696df19c1352d9.jpg');
insert into usuario (email, nome_completo, senha, ativo, data_nascimento, apelido, imagem_perfil) values ('cunha@cwi.com.br', 'Cunha Cunha', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', true, '2000-01-01', 'Nha', 'https://this-person-does-not-exist.com/img/avatar-117823b2b48b5096e02fd7705c85a1fe.jpg');
insert into usuario (email, nome_completo, senha, ativo, data_nascimento, apelido, imagem_perfil) values ('pereira@cwi.com.br', 'Pereira Pereira', '$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', true, '2000-01-01', 'Per', 'https://this-person-does-not-exist.com/img/avatar-1146eb7ee2b616bb0212d5d5228dcd92.jpg');

insert into permissao (nome, usuario_id) values ('ADMIN', 1);
insert into permissao (nome, usuario_id) values ('USUARIO', 1);
insert into permissao (nome, usuario_id) values ('USUARIO', 2);
insert into permissao (nome, usuario_id) values ('USUARIO', 3);
insert into permissao (nome, usuario_id) values ('USUARIO', 4);


//Senha 123456