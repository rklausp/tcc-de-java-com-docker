import { useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import useGlobalUser from "../../../context/user/user.context";
import { useGetFriends } from "../../../hooks/use-get-friends.hook";
import { usePagination } from "../../../hooks/use-pagination.hook";

export function FriendslistScreen() {
  const [user, setUser] = useGlobalUser();
  const navigate = useNavigate();

  const { fetchFriends, friends, loading, error } = useGetFriends();
  const { page, handlePreviousPage, handleNextPage } = usePagination();

  useEffect(() => {
    fetchFriends(page);
  }, [page]);

  function showFriends() {
    if (loading) {
      return <h3 className="loading">Conteudo carregando</h3>;
    }

    if (error) {
      return <h3 className="error">Erro</h3>;
    }

    return friends.map((friend) => {
      return (
        <div>
          <Link to={`/users/${friend.id}`}>
            <div className="card-post" key={friend?.id}>
              <p className="dado poster">{friend?.nomeCompleto}</p>
            </div>
          </Link>
        </div>
      );
    });
  }

  const disableNegativePages = page <= 0;

  return (
    <div>
      <div className="posts">{showFriends()}</div>

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
