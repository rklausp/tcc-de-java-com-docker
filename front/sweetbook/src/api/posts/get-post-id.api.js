import { axiosInstance } from "../_base/axios-instance";

export async function getPostId(id) {
  const response = await axiosInstance.get(`/posts/${id}`);
  return response.data;
}
