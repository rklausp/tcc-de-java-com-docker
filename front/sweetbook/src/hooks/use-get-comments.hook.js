import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getComments } from "../api/posts/get-comments.api";
import useGlobalUser from "../context/user/user.context";

export function useGetComments(id) {
  const [comments, setComments] = useState([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);
  const [, setUser] = useGlobalUser();
  const navigate = useNavigate();

  async function obterComments() {
    try {
      const response = await getComments(id);
      setComments(response);
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
    obterComments();
  }, [comments]);

  return { comments, error, loading };
}
