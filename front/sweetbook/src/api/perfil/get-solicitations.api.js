import { axiosInstance } from "../_base/axios-instance";

export async function getSolicitations() {
  const response = await axiosInstance.get(`/amizades/solicitacoes`);
  return response.data;
}
