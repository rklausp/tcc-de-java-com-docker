import { axiosInstance } from "../_base/axios-instance";

export async function getOtherPosts(id, page) {
  const response = await axiosInstance.get(
    `/posts/${id}/outro?size=4&page=${page}&sort=horaPost,desc`
  );
  return response.data.content;
}
