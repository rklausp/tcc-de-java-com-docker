import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { getFriends } from "../api/perfil/get-friends.api";
import useGlobalUser from "../context/user/user.context";

export function useGetFriends() {
  const [friends, setFriends] = useState([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);
  const [, setUser] = useGlobalUser();
  const navigate = useNavigate();

  async function fetchFriends(page) {
    try {
      const response = await getFriends(page);
      setFriends(response);
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

  return { fetchFriends, friends, error, loading };
}
