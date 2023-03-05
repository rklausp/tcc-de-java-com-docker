import { useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import { logout } from "../../../api/user/logout.api";
import useGlobalUser from "../../../context/user/user.context";
import { useGetMyProfile } from "../../../hooks/use-get-my-profile.hook";
import { Feed } from "../../components/feed/feed";
import { PostPost } from "../../components/post-post/post-post";

export function PerfilScreen() {
  const { profile, loading, error } = useGetMyProfile();
  const [user, setUser] = useGlobalUser();
  const navigate = useNavigate();

  useEffect(() => {
    if (!user) {
      navigate("/");
    }
  }, []);

  async function handleClickLogout() {
    await logout();

    setUser(null);
    localStorage.removeItem("user");
  }

  function showUserProfile() {
    if (loading) {
      return <h3 className="problem">Perfil Carregando</h3>;
    }

    if (error) {
      return <h3 className="problem">Erro ao tentar acessar perfil</h3>;
    }

    return (
      <div className="profile-info">
        <img src={profile?.imagemPerfil}></img>
        <p className="name">Perfil de {profile?.nomeCompleto}</p>
        <p className="nickname">{profile?.apelido}</p>
        <p className="birth-date">
          Data de nascimento{profile?.dataNascimento}
        </p>
        <p className="email">Email cadastrado: {profile?.email}</p>
      </div>
    );
  }

  return (
    <div>
      <p>Seu perfil</p>
      <button onClick={handleClickLogout}>LOGOUT</button>
      {showUserProfile()}

      <Link to={"/users"}>
        <button className="search-users">Buscar outros doceiros</button>
      </Link>

      <Link to={`/solicitations`}>
        <button className="solicitation">Ver Solicitacoes de Amizade</button>
      </Link>

      <Link to={`/friends`}>
        <button className="friends">Ver Lista de Amigos</button>
      </Link>

      <Link to={`/user/alter`}>
        <button className="alter">Atualizar Perfil</button>
      </Link>

      <p>Faca um post</p>
      <PostPost />
      <Feed />
    </div>
  );
}
