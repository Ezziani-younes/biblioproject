import { AppBar, Toolbar, Typography, Button } from "@mui/material";
import { Link } from "react-router-dom";
function Navbar() {
  return (
    <AppBar position="static">
      <Toolbar>
        <Typography variant="h6" sx={{ flexGrow: 1 }}>
          📚 BiblioApp
        </Typography>

        <Button color="inherit">Accueil</Button>
        <Button color="inherit">Livres</Button>
        <Button color="inherit" component={Link} to="/inscription">
                  Inscription
                  </Button>
      </Toolbar>
    </AppBar>
  );
}

export default Navbar;