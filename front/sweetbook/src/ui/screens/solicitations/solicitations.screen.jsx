import { useNavigate } from "react-router-dom";
import { putAcceptSolicitation } from "../../../api/perfil/put-accept-solicitation.api";
import useGlobalUser from "../../../context/user/user.context";
import { useGetSolicitations } from "../../../hooks/use-get-solicitations.hook";
import { useToastr } from "../../../hooks/use-toastr.hook";

export function SolicitationsScreen() {
  const [user, setUser] = useGlobalUser();
  const navigate = useNavigate();
  const showToastr = useToastr();

  const { solicitations, loading, error } = useGetSolicitations();

  async function acceptSolicitation(id) {
    try {
      await putAcceptSolicitation(id);
    } catch (error) {
      showToastr(error?.response?.data?.message);
      if (error.response.status === 401) {
        setUser(null);
        localStorage.removeItem("user");
        navigate("/");
      }
    }
  }

  function showSolicitations() {
    if (loading) {
      return <h3 className="loading">Likes carregando</h3>;
    }

    if (error) {
      return <h3 className="error">Erro Likes</h3>;
    }

    return solicitations.map((solicitation) => {
      return (
        <div className="card-post" key={solicitation?.amizadeId}>
          <p className="dado poster">
            Aceita o pedido de amizade de {solicitation?.nomeSolicitante}?
          </p>
          <button onClick={() => acceptSolicitation(solicitation?.amizadeId)}>
            Aceito
          </button>
        </div>
      );
    });
  }

  return <div>{showSolicitations()}</div>;
}
