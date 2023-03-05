import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getSearchUsers } from "../api/perfil/get-search-users.api";
import useGlobalUser from "../context/user/user.context";

export function useGetSearchUsers() {
  const [users, setUsers] = useState([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);
  const [, setUser] = useGlobalUser();
  const navigate = useNavigate();

  async function fetchUsers(page) {
    try {
      const response = await getSearchUsers(page);
      setUsers(response);
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

  return { fetchUsers, users, error, loading };
}
