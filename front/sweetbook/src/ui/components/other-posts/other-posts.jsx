import { useEffect } from "react";
import { Link, useParams } from "react-router-dom";
import { useGetOtherPosts } from "../../../hooks/use-get-other-posts.api";
import { usePagination } from "../../../hooks/use-pagination.hook";

export function OtherPosts() {
  const params = useParams();
  const { id } = params;

  const { fetchOtherPosts, otherPosts, loading, error } = useGetOtherPosts(id);
  const { page, handlePreviousPage, handleNextPage } = usePagination();

  useEffect(() => {
    fetchOtherPosts(page);
  }, [page]);

  function showOtherPosts() {
    if (loading) {
      return <h3 className="loading">Conteudo carregando</h3>;
    }

    if (error) {
      return <h3 className="error">Erro</h3>;
    }

    return otherPosts.map((otherPosts) => {
      return (
        <div>
          <Link to={`/perfil/post/${otherPosts.id}`}>
            <div className="card-post" key={otherPosts?.id}>
              <p className="dado poster">{otherPosts?.usuarioNome}</p>
              <p className="dado time">{otherPosts?.horaPost}</p>
              <p className="dado text">{otherPosts?.texto}</p>
              <img src={otherPosts?.imagemUrl} className="post-image"></img>
            </div>
          </Link>
        </div>
      );
    });
  }

  const disableNegativePages = page <= 0;

  return (
    <div>
      <div className="posts">{showOtherPosts()}</div>

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
