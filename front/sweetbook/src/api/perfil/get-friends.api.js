import { axiosInstance } from "../_base/axios-instance";

export async function getFriends(page) {
  const response = await axiosInstance.get(
    `amizades/listarAmigos?text=&size=4&page=${page}&sort=nomeCompleto`
  );
  return response.data.content;
}
