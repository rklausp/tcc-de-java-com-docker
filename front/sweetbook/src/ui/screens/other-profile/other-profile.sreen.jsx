import { useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { deleteSolicitation } from "../../../api/perfil/delete-solicitation.api";
import { postSolicitation } from "../../../api/perfil/post-solicitation.api";
import useGlobalUser from "../../../context/user/user.context";
import { useGetOtherProfile } from "../../../hooks/use-get-other-profile.hook";
import { useToastr } from "../../../hooks/use-toastr.hook";
import { OtherPosts } from "../../components/other-posts/other-posts";

export function OtherProfileScreen() {
  const [user, setUser] = useGlobalUser();
  const navigate = useNavigate();
  const params = useParams();
  const { id } = params;
  const { otherProfile, loading, error } = useGetOtherProfile(id);
  const showToastr = useToastr();

  useEffect(() => {
    if (!user) {
      navigate("/");
    }
  }, []);

  function showUserProfile() {
    if (loading) {
      return <h3 className="problem">Perfil Carregando</h3>;
    }

    if (error) {
      return <h3 className="problem">Erro ao tentar acessar perfil</h3>;
    }

    return (
      <div className="profile-info">
        <img src={otherProfile?.imagemPerfil}></img>
        <p className="name">Perfil de {otherProfile?.nomeCompleto}</p>
        <p className="nickname">{otherProfile?.apelido}</p>
        <p className="birth-date">
          Data de nascimento{otherProfile?.dataNascimento}
        </p>
        <p className="email">Email cadastrado: {otherProfile?.email}</p>
      </div>
    );
  }

  function renderButton() {
    if (otherProfile?.amigo) {
      return <button onClick={removeFriend}>REMOVER RELACAO</button>;
    }
    return <button onClick={solicitation}>ENVIAR PEDIDO DE AMIZADE</button>;
  }

  async function solicitation() {
    try {
      await postSolicitation(id);
    } catch (error) {
      showToastr(error?.response?.data?.message);
      if (error.response.status === 401) {
        setUser(null);
        localStorage.removeItem("user");
        navigate("/");
      }
    }
    showToastr("Pedido enviado!");
  }

  async function removeFriend() {
    try {
      await deleteSolicitation(id);
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
    <div>
      {showUserProfile()}
      {renderButton()}
      <OtherPosts />
    </div>
  );
}
