import { useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { deleteLike } from "../../../api/posts/delete-like.api";
import { postLike } from "../../../api/posts/post.like.api";
import useGlobalUser from "../../../context/user/user.context";
import { useGetComments } from "../../../hooks/use-get-comments.hook";
import { useGetLikes } from "../../../hooks/use-get-likes.hook";
import { useGetPostId } from "../../../hooks/use-get-post-id.hook";
import { useToastr } from "../../../hooks/use-toastr.hook";
import { Comment } from "../../components/comment/comment";

export function PostScreen() {
  const navigate = useNavigate();
  const params = useParams();
  const { id } = params;
  const { post } = useGetPostId(id);
  const { likes, loading, error } = useGetLikes(id);
  const { comments, loadingC, errorC } = useGetComments(id);
  const [user, setUser] = useGlobalUser();
  const showToastr = useToastr();

  async function likePost() {
    try {
      await postLike(id);
    } catch (error) {
      showToastr("Nao pode dar like duas vezes");
      if (error.response.status === 401) {
        setUser(null);
        localStorage.removeItem("user");
        navigate("/");
      }
    }
  }

  async function dislikePost() {
    try {
      await deleteLike(id);
    } catch (error) {
      showToastr("So pode tirar like de posts que deu like");
      if (error.response.status === 401) {
        setUser(null);
        localStorage.removeItem("user");
        navigate("/");
      }
    }
  }

  useEffect(() => {
    showLikes();
  }, [likes]);

  function showLikes() {
    if (loading) {
      return <h3 className="loading">Likes carregando</h3>;
    }

    if (error) {
      return <h3 className="error">Erro Likes</h3>;
    }

    return likes.map((like) => {
      return (
        <div className="card-post" key={like?.idUsuario}>
          <p className="dado poster">{like?.nomeUsuario}</p>
        </div>
      );
    });
  }

  function showComments() {
    if (loadingC) {
      return <h3 className="loading">Likes carregando</h3>;
    }

    if (errorC) {
      return <h3 className="error">Erro Likes</h3>;
    }

    return comments.map((like, index) => {
      return (
        <div className="card-post" key={index}>
          <p className="dado poster">{like?.nomeUsuario}</p>
          <p className="dado poster">{like?.texto}</p>
        </div>
      );
    });
  }

  function renderPostInfo() {
    return (
      <div className="post-container">
        <p className="dado poster">{post?.usuarioNome}</p>
        <p className="dado time">{post?.horaPost}</p>
        <p className="dado text">{post?.texto}</p>
        <img src={post?.imagemUrl} className="post-image"></img>
        <button onClick={likePost}>Curtir</button>
        <button onClick={dislikePost}>Remover curtida</button>
      </div>
    );
  }

  return (
    <section className="passageiro-selecionado-detalhes">
      <div className="info-container">{renderPostInfo()}</div>
      <div>{showLikes()}</div>
      <Comment id={id} />
      {showComments()}
    </section>
  );
}
