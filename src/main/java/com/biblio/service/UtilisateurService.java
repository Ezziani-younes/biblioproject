package com.biblio.service;

import com.biblio.model.Utilisateur;
import com.biblio.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    // 🔹 1. Récupérer tous les utilisateurs
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // 🔹 2. Ajouter un utilisateur (AMÉLIORÉ)
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {

        // ✅ Validation email
        if (utilisateur.getEmail() == null || utilisateur.getEmail().isEmpty()) {
            throw new RuntimeException("Email obligatoire");
        }

        // ✅ Vérifier si email existe déjà
        if (utilisateurRepository.findByEmail(utilisateur.getEmail()).isPresent()) {
            throw new RuntimeException("Email déjà utilisé");
        }

        // ✅ Validation mot de passe
        if (utilisateur.getMotDePasse() == null || utilisateur.getMotDePasse().length() < 6) {
            throw new RuntimeException("Mot de passe trop court");
        }

        return utilisateurRepository.save(utilisateur);
    }

    // 🔹 3. Trouver utilisateur par email
    public Utilisateur getByEmail(String email) {
        return utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    // 🔹 4. Trouver utilisateur par ID
    public Utilisateur getById(Long id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
    }
}

