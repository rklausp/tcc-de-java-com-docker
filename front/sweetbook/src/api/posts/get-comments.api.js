import { axiosInstance } from "../_base/axios-instance";

export async function getComments(id) {
  const response = await axiosInstance.get(`/posts/${id}/comentarios`);
  return response.data;
}
