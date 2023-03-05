import { axiosInstance } from "../_base/axios-instance";

export async function createUser({
  nomeCompleto,
  email,
  senha,
  apelido,
  dataNascimento,
  imagemPerfil,
}) {
  const response = await axiosInstance.post("/usuarios", {
    nomeCompleto,
    email,
    senha,
    apelido,
    dataNascimento,
    imagemPerfil,
    permissoes: ["USUARIO"],
  });
  return response.data;
}
