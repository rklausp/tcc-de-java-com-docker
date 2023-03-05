import { axiosInstance } from "../_base/axios-instance";

export async function postSolicitation(id) {
  const response = await axiosInstance.post(
    `/amizades/${id}/enviarSolicitacao`
  );
  return response.data;
}
