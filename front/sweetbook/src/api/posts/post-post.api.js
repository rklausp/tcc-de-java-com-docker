import { axiosInstance } from "../_base/axios-instance";

export async function postPost({ texto, imagemUrl, tipo }) {
  await axiosInstance.post("/posts", {
    texto,
    imagemUrl,
    tipo,
  });
}
