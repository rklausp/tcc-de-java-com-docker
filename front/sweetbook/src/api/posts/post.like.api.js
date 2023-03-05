import { axiosInstance } from "../_base/axios-instance";

export async function postLike(id) {
  const response = await axiosInstance.post(`/posts/${id}/curtir`);
  return response.data;
}
