import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getSolicitations } from "../api/perfil/get-solicitations.api";
import useGlobalUser from "../context/user/user.context";

export function useGetSolicitations() {
  const [solicitations, setSolicitations] = useState([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);
  const [, setUser] = useGlobalUser();
  const navigate = useNavigate();

  async function obterSolicitacoes() {
    try {
      const response = await getSolicitations();
      setSolicitations(response);
    } catch (error) {
      if (error.response.status === 401) {
        setUser(null);
        localStorage.removeItem("user");
        navigate("/");
      }
      setError(error);
    } finally {
      setLoading(false);
    }
  }

  useEffect(() => {
    obterSolicitacoes();
  }, [solicitations]);

  return { solicitations, error, loading };
}
