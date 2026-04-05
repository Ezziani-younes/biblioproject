package com.biblio.controller;


import com.biblio.model.Utilisateur;
import com.biblio.service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    // 🔹 1. Ajouter un utilisateur
    @PostMapping
    public Utilisateur ajouter(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.saveUtilisateur(utilisateur);
    }

    // 🔹 2. Récupérer tous les utilisateurs
    @GetMapping
    public List<Utilisateur> getAll() {
        return utilisateurService.getAllUtilisateurs();
    }

    // 🔹 3. Trouver utilisateur par ID
    @GetMapping("/{id}")
    public Utilisateur getById(@PathVariable Long id) {
        return utilisateurService.getById(id);
    }

    // 🔹 4. Trouver utilisateur par email
    @GetMapping("/by-email")
    public Utilisateur getByEmail(@RequestParam String email) {
        return utilisateurService.getByEmail(email);
    }
}