import { useEffect, useState } from "react";
import Navbar from "../components/Navbar";
import LivreCard from "../components/LivreCard";
import { getLivres } from "../services/livreService";
import { Container, Grid, Typography, Button } from "@mui/material";

interface Livre {
  id: number;
  titre: string;
  auteur: string;
  disponible: boolean;
}

function Home() {
  const [livres, setLivres] = useState<Livre[]>([]);

  useEffect(() => {
    getLivres()
      .then((data) => setLivres(data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <>
      <Navbar />

      <Container sx={{ marginTop: 4 }}>
        <Typography variant="h4" gutterBottom>
          📚 Nos Livres
        </Typography>

        <Grid container spacing={3}>
          {livres.map((livre) => (
            <Grid item xs={12} sm={6} md={4} key={livre.id}>
              <LivreCard livre={livre} />
            </Grid>
          ))}
        </Grid>

        <Typography variant="h4" sx={{ marginTop: 6 }}>
          👤 Rejoignez-nous
        </Typography>

        <Button variant="contained" color="secondary" sx={{ marginTop: 2 }}>
          S'inscrire
        </Button>
      </Container>
    </>
  );
}

export default Home;