import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import useGlobalUser from "../../../context/user/user.context";
import { useGetSearchUsers } from "../../../hooks/use-get-search-users.hook";
import { usePagination } from "../../../hooks/use-pagination.hook";

export function UsersScreen() {
  const [user, setUser] = useGlobalUser();
  const { fetchUsers, users, error, loading } = useGetSearchUsers();
  const { page, handlePreviousPage, handleNextPage } = usePagination();
  const navigate = useNavigate();

  useEffect(() => {
    fetchUsers(page);
  }, [page]);

  function renderUsers() {
    if (loading) {
      return <h3 className="problem">Perfil Carregando</h3>;
    }

    if (error) {
      return <h3 className="problem">Erro ao tentar acessar perfil</h3>;
    }

    return users.map((user) => {
      return (
        <div>
          <Link to={`/users/${user?.id}`}>
            <div className="card-post" key={user?.id}>
              <img src={user?.imagemPerfil}></img>
              <p className="name">Perfil de {user?.nomeCompleto}</p>
              <p className="nickname">{user?.apelido}</p>
              <p className="email">Email cadastrado: {user?.email}</p>
            </div>
          </Link>
        </div>
      );
    });
  }

  const disableNegativePages = page <= 0;

  function showUsers() {
    return (
      <div>
        <div className="posts">{renderUsers()}</div>

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

  return <div>{showUsers()}</div>;
}
