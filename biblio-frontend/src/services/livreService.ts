import API from "./api";

export const getLivres = async () => {
  const response = await API.get("/livres");
  return response.data;
};