import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { putAlterUser } from "../../../api/user/put-alter-user.api";
import useGlobalUser from "../../../context/user/user.context";
import { useGetMyProfile } from "../../../hooks/use-get-my-profile.hook";
import { useToastr } from "../../../hooks/use-toastr.hook";

export function AlterUserScreen() {
  const [formInput, setFormInput] = useState({
    nomeCompleto: "",
    apelido: "",
    imagemPerfil: "",
  });
  const navigate = useNavigate();
  const [user, setUser] = useGlobalUser();
  const { profile, loading, error } = useGetMyProfile();
  const showToastr = useToastr();

  function handleChange(event) {
    const { name, value } = event.target;

    setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
  }

  async function handleSubmit(event) {
    event.preventDefault();

    try {
      await putAlterUser({
        nomeCompleto: formInput.nomeCompleto,
        apelido: formInput.apelido,
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
          <label>Novo Nome</label>
          <input
            onChange={handleChange}
            name="nomeCompleto"
            value={formInput.nomeCompleto}
            placeholder="Digite novo nome"
          />
        </div>
        <div>
          <label>Novo Apelido</label>
          <input
            onChange={handleChange}
            name="apelido"
            value={formInput.apelido}
            placeholder="Digite novo apelido"
          />
        </div>
        <div>
          <label>Nova imagem</label>
          <input
            onChange={handleChange}
            value={formInput.imagemPerfil}
            name="imagemPerfil"
            placeholder="Digite novo link da sua Imagem"
          />
        </div>
        <button onClick={handleSubmit}>Enviar</button>
      </form>
    </div>
  );
}
