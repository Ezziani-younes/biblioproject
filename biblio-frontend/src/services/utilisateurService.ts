import API from "./api";

export const inscrireUtilisateur = async (user: {
  nom: string;
  email: string;
  motDePasse: string;
}) => {
  const response = await API.post("/utilisateurs", user);
  return response.data;
};