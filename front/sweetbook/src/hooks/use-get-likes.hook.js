import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getLikes } from "../api/posts/get-likes.api";
import useGlobalUser from "../context/user/user.context";

export function useGetLikes(id) {
  const [likes, setLikes] = useState([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);
  const [, setUser] = useGlobalUser();
  const navigate = useNavigate();

  async function obterLikes() {
    try {
      const response = await getLikes(id);
      setLikes(response);
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
    obterLikes();
  }, [likes]);

  return { likes, error, loading };
}
