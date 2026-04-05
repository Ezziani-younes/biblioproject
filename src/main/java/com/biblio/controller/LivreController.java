package com.biblio.controller;


import com.biblio.model.Livre;
import com.biblio.service.LivreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livres")
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    // 🔹 Ajouter un livre
    @PostMapping
    public Livre ajouter(@RequestBody Livre livre) {
        return livreService.saveLivre(livre);
    }

    // 🔹 Liste des livres
    @GetMapping
    public List<Livre> getAllLivres() {
        return livreService.getAllLivres();
    }

    // 🔹 Recherche par titre
    @GetMapping("/search")
    public List<Livre> search(@RequestParam String titre) {
        return livreService.searchByTitre(titre);
    }

    // 🔹 Livres disponibles
    @GetMapping("/disponibles")
    public List<Livre> disponibles() {
        return livreService.getLivresDisponibles();
    }

    // 🔹 Supprimer
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        livreService.deleteLivre(id);
    }
    @GetMapping("/{id}")
    public Livre getById(@PathVariable Long id) {
        return livreService.getLivreById(id);
    }
}