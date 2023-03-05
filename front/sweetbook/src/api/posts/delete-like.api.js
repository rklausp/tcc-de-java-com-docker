import { axiosInstance } from "../_base/axios-instance";

export async function deleteLike(id) {
  const response = await axiosInstance.delete(`/posts/${id}/descurtir`);
  return response.data;
}
