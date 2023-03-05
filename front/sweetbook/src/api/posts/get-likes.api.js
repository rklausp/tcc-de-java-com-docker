import { axiosInstance } from "../_base/axios-instance";

export async function getLikes(id) {
  const response = await axiosInstance.get(`/posts/${id}/curtidas`);
  return response.data;
}
