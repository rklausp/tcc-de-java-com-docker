import { axiosInstance } from "../_base/axios-instance";

export async function postComment({ id, texto }) {
  const response = await axiosInstance.post(`/posts/${id}/comentar`, {
    texto,
  });
  return response.data;
}
