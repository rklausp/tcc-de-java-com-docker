import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { login } from "../../../api/user/login.api";
import useGlobalUser from "../../../context/user/user.context";
import { useToastr } from "../../../hooks/use-toastr.hook";

export function LoginScreen() {
  const [formInput, setFormInput] = useState({ email: "", senha: "" });
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
      const user = await login({
        username: formInput.email,
        password: formInput.senha,
      });
      setUser(user);
    } catch (error) {
      showToastr(error.response?.data?.message);
    }
  }

  useEffect(() => {
    if (user) {
      navigate("/perfil");
    }
  }, [user]);

  return (
    <div className="incluir-box">
      <form className="incluir-form" onSubmit={handleSubmit}>
        <h1>Logue-se</h1>
        <div>
          <label>Email</label>
          <input
            onChange={handleChange}
            name="email"
            value={formInput.email}
            placeholder="Digite seu email de login"
          />
        </div>
        <div>
          <label>Senha</label>
          <input
            onChange={handleChange}
            name="senha"
            value={formInput.senha}
            placeholder="Digite sua senha"
          />
        </div>
        <button onClick={handleSubmit}>Enviar</button>
      </form>

      <Link to={"/cadastro"}>
        <button>CADASTRAR-SE</button>
      </Link>
    </div>
  );
}
