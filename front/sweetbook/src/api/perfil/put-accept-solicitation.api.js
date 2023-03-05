import { axiosInstance } from "../_base/axios-instance";

export async function putAcceptSolicitation(id) {
  const response = await axiosInstance.put(`/amizades/${id}/aceitar`);
  return response.data;
}
