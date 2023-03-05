import { axiosInstance } from "../_base/axios-instance";

export async function putAlterUser({ nomeCompleto, apelido, imagemPerfil }) {
  const response = await axiosInstance.put(`/perfil/`, {
    nomeCompleto: nomeCompleto,
    apelido: apelido,
    imagem: imagemPerfil,
  });
  return response.data;
}
