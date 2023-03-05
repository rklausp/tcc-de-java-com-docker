import { axiosInstance } from "../_base/axios-instance";

export async function getFeed(page) {
  const response = await axiosInstance.get(
    `/posts/feed?size=4&page=${page}&sort=horaPost,desc`
  );
  return response.data.content;
}
