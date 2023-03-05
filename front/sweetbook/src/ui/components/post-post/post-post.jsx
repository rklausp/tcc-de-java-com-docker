import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { postPost } from "../../../api/posts/post-post.api";
import useGlobalUser from "../../../context/user/user.context";
import { useToastr } from "../../../hooks/use-toastr.hook";

export function PostPost() {
  const [user, setUser] = useGlobalUser();
  const [formInput, setFormInput] = useState({
    texto: "",
    imagemUrl: "",
    tipo: "",
  });
  const navigate = useNavigate();
  const showToastr = useToastr();

  function handleChange(event) {
    const { name, value } = event.target;

    setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
  }

  async function handleSubmit(event) {
    event.preventDefault();

    try {
      await postPost({
        texto: formInput.texto,
        imagemUrl: formInput.imagemUrl,
        tipo: formInput.tipo,
      });
    } catch (error) {
      showToastr("Faltam informacoes para fazer post!");
      if (error.response.status === 401) {
        setUser(null);
        localStorage.removeItem("user");
        navigate("/");
      }
    }
  }

  return (
    <section className="fazer-post">
      <form className="criar-post" onSubmit={handleSubmit}>
        <h2 className="titulo-form">Fazer Post</h2>
        <input
          className="form-input"
          name="texto"
          autoComplete="off"
          placeholder="Digite sua receita"
          value={formInput.texto}
          onChange={handleChange}
        />
        <input
          className="form-input"
          name="imagemUrl"
          autoComplete="off"
          placeholder="Link da imagem"
          value={formInput.imagemUrl}
          onChange={handleChange}
        />
        <label className="form-label">Selecione a Categoria</label>
        <select
          name="tipo"
          className="form-select"
          value={formInput.tipo}
          onChange={handleChange}
        >
          <option value="" disabled></option>
          <option value="PUBLICO">Publico</option>
          <option value="PRIVADO">Privado</option>
        </select>

        <button className="postar" onClick={handleSubmit}>
          POSTAR
        </button>
      </form>
    </section>
  );
}
