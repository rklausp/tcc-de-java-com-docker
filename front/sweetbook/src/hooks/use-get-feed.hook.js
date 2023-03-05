import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getFeed } from "../api/posts/get-feed.api";
import useGlobalUser from "../context/user/user.context";

export function useGetFeed() {
  const [feed, setFeed] = useState([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);
  const [, setUser] = useGlobalUser();
  const navigate = useNavigate();

  async function fetchFeed(page) {
    try {
      const response = await getFeed(page);
      setFeed(response);
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

  return { fetchFeed, feed, error, loading };
}
