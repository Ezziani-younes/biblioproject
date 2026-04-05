import { useState } from "react";
import Navbar from "../components/Navbar";
import { Container, TextField, Button, Typography } from "@mui/material";
import { inscrireUtilisateur } from "../services/utilisateurService";

function Inscription() {
  const [nom, setNom] = useState("");
  const [email, setEmail] = useState("");
  const [motDePasse, setMotDePasse] = useState("");

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    try {
      await inscrireUtilisateur({
        nom,
        email,
        motDePasse,
      });

      alert("Inscription réussie !");
    } catch (error) {
      console.error(error);
      alert("Erreur lors de l'inscription");
    }
  };

  return (
    <>
      <Navbar />

      <Container maxWidth="sm" sx={{ marginTop: 5 }}>
        <Typography variant="h4" gutterBottom>
          📝 Inscription
        </Typography>

        <form onSubmit={handleSubmit}>
          <TextField
            label="Nom complet"
            fullWidth
            margin="normal"
            value={nom}
            onChange={(e) => setNom(e.target.value)}
          />

          <TextField
            label="Email"
            type="email"
            fullWidth
            margin="normal"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />

          <TextField
            label="Mot de passe"
            type="password"
            fullWidth
            margin="normal"
            value={motDePasse}
            onChange={(e) => setMotDePasse(e.target.value)}
          />

          <Button
            type="submit"
            variant="contained"
            fullWidth
            sx={{ marginTop: 2 }}
          >
            S'inscrire
          </Button>
        </form>
      </Container>
    </>
  );
}

export default Inscription;