import { axiosInstance } from "../_base/axios-instance";

export async function getSearchUsers(page) {
  const response = await axiosInstance.get(
    `/perfil/buscar?text=&size=4&page=${page}&sort=nomeCompleto`
  );
  return response.data.content;
}
