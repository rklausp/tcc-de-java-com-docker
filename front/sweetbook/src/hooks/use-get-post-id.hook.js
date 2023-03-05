import { useEffect, useState } from "react";
import { getPostId } from "../api/posts/get-post-id.api";

export function useGetPostId(id) {
  const [post, setPost] = useState([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);

  async function obterPost() {
    try {
      const resposta = await getPostId(id);
      setPost(resposta);
    } catch (error) {
      setError(error);
    } finally {
      setLoading(false);
    }
  }

  useEffect(() => {
    obterPost();
  }, [post]);

  return { post, error, loading };
}
