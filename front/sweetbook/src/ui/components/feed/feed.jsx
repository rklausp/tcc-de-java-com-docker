import { useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import useGlobalUser from "../../../context/user/user.context";
import { useGetFeed } from "../../../hooks/use-get-feed.hook";
import { usePagination } from "../../../hooks/use-pagination.hook";

export function Feed() {
  const { fetchFeed, feed, loading, error } = useGetFeed();
  const [user, setUser] = useGlobalUser();
  const navigate = useNavigate();
  const { page, handlePreviousPage, handleNextPage } = usePagination();

  useEffect(() => {
    fetchFeed(page);
  }, [page]);

  function showFeed() {
    if (loading) {
      return <h3 className="loading">Conteudo carregando</h3>;
    }

    if (error) {
      return <h3 className="error">Erro</h3>;
    }

    return feed.map((post) => {
      return (
        <div>
          <Link to={`post/${post.id}`}>
            <div className="card-post" key={post?.id}>
              <p className="dado poster">{post?.usuarioNome}</p>
              <p className="dado time">{post?.horaPost}</p>
              <p className="dado text">{post?.texto}</p>
              <img src={post?.imagemUrl} className="post-image"></img>
            </div>
          </Link>
        </div>
      );
    });
  }

  const disableNegativePages = page <= 0;

  return (
    <div>
      <div className="posts">{showFeed()}</div>

      <div className="feed-pagination">
        <button
          onClick={handlePreviousPage}
          disabled={disableNegativePages}
          className="feed-button-pagination"
        >
          Página anterior
        </button>

        <div className="current-page">{page}</div>

        <button onClick={handleNextPage} className="feed-button-pagination">
          Próxima página
        </button>
      </div>
    </div>
  );
}
