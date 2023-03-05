import { axiosInstance } from "../_base/axios-instance";

export async function deleteSolicitation(id) {
  const response = await axiosInstance.delete(`/amizades/${id}`);
  return response.data;
}
