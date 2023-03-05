import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createUser } from "../../../api/user/create-user.api";
import useGlobalUser from "../../../context/user/user.context";
import { useToastr } from "../../../hooks/use-toastr.hook";

export function CreateUserScreen() {
  const [formInput, setFormInput] = useState({
    email: "",
    senha: "",
    nomeCompleto: "",
    dataNascimento: "",
    apelido: "",
    imagemPerfil: "",
  });
  const navigate = useNavigate();
  const [user, setUser] = useGlobalUser();
  const showToastr = useToastr();

  function handleChange(event) {
    const { name, value } = event.target;

    setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
  }

  async function handleSubmit(event) {
    event.preventDefault();

    try {
      await createUser({
        nomeCompleto: formInput.nomeCompleto,
        email: formInput.email,
        senha: formInput.senha,
        apelido: formInput.apelido,
        dataNascimento: formInput.dataNascimento,
        imagemPerfil: formInput.imagemPerfil,
      });
    } catch (error) {
      showToastr(error?.response?.data?.message);
    }
  }

  return (
    <div className="incluir-box">
      <form className="incluir-form" onSubmit={handleSubmit}>
        <h1>Cadastrar-se</h1>
        <div>
          <label>Nome Completo</label>
          <input
            onChange={handleChange}
            name="nomeCompleto"
            value={formInput.nomeCompleto}
            placeholder="Digite seu nome completo"
          />
        </div>
        <div>
          <label>Data de nascimento</label>
          <input
            onChange={handleChange}
            name="dataNascimento"
            value={formInput.dataNascimento}
            placeholder="Digite sua data de nascimento"
          />
        </div>
        <div>
          <label>email</label>
          <input
            onChange={handleChange}
            name="email"
            value={formInput.email}
            placeholder="Digite seu email"
          />
        </div>
        <div>
          <label>Apelido</label>
          <input
            onChange={handleChange}
            name="apelido"
            value={formInput.apelido}
            placeholder="Digite seu apelido"
          />
        </div>
        <div>
          <label>Senha</label>
          <input
            onChange={handleChange}
            value={formInput.senha}
            name="senha"
            placeholder="Digite sua senha"
          />
        </div>
        <div>
          <label>Imagem de Perfil</label>
          <input
            onChange={handleChange}
            value={formInput.imagemPerfil}
            name="imagemPerfil"
            placeholder="Digite link da sua Imagem"
          />
        </div>
        <button onClick={handleSubmit}>Enviar</button>
      </form>
    </div>
  );
}
