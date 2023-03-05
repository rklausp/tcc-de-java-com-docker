import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { getOtherPosts } from "../api/posts/get-other-posts.api";
import useGlobalUser from "../context/user/user.context";

export function useGetOtherPosts(id) {
  const [otherPosts, setOtherPosts] = useState([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);
  const [, setUser] = useGlobalUser();
  const navigate = useNavigate();

  async function fetchOtherPosts(page) {
    try {
      const response = await getOtherPosts(id, page);
      setOtherPosts(response);
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

  return { fetchOtherPosts, otherPosts, error, loading };
}
