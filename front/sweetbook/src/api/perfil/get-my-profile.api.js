import { axiosInstance } from "../_base/axios-instance";

export async function getMyProfile() {
  const response = await axiosInstance.get("/perfil");
  return response.data;
}
