import { axiosInstance } from "../_base/axios-instance";

export async function getOtherProfile(id) {
  const response = await axiosInstance.get(`/perfil/${id}`);
  return response.data;
}
