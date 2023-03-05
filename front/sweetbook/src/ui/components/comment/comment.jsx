import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { postComment } from "../../../api/posts/post-comment.api";
import useGlobalUser from "../../../context/user/user.context";
import { useToastr } from "../../../hooks/use-toastr.hook";

export function Comment({ id }) {
  const [user, setUser] = useGlobalUser();
  const [formInput, setFormInput] = useState({ texto: "" });
  const navigate = useNavigate();
  const showToastr = useToastr();

  function handleChange(event) {
    const { name, value } = event.target;

    setFormInput((oldFormInput) => ({ ...oldFormInput, [name]: value }));
  }

  async function handleSubmit(event) {
    event.preventDefault();

    try {
      await postComment({
        id: id,
        texto: formInput.texto,
      });
    } catch (error) {
      showToastr(error?.response?.data?.message);
      if (error.response.status === 401) {
        setUser(null);
        localStorage.removeItem("user");
        navigate("/");
      }
    }
  }

  return (
    <section className="fazer-comentario">
      <form className="comentar" onSubmit={handleSubmit}>
        <input
          className="form-input"
          name="texto"
          autoComplete="off"
          placeholder="Comente o que deseja"
          value={formInput.texto}
          onChange={handleChange}
        />

        <button className="comentar" onClick={handleSubmit}>
          COMENTAR
        </button>
      </form>
    </section>
  );
}
