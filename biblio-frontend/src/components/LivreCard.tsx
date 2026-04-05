import { Card, CardContent, Typography, Button } from "@mui/material";

interface Livre {
  id: number;
  titre: string;
  auteur: string;
  disponible: boolean;
}

function LivreCard({ livre }: { livre: Livre }) {
  return (
    <Card>
      <CardContent>
        <Typography variant="h6">{livre.titre}</Typography>

        <Typography variant="body2">
          Auteur: {livre.auteur}
        </Typography>

        <Typography variant="body2">
          Disponible: {livre.disponible ? "Oui" : "Non"}
        </Typography>

        <Button
          variant="contained"
          sx={{ marginTop: 2 }}
          disabled={!livre.disponible}
        >
          Emprunter
        </Button>
      </CardContent>
    </Card>
  );
}

export default LivreCard;