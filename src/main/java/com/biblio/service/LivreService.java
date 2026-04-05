package com.biblio.service;

import com.biblio.model.Livre;
import com.biblio.repository.LivreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {

    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    // 🔹 1. Récupérer tous les livres
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    // 🔹 2. Ajouter ou modifier un livre
    public Livre saveLivre(Livre livre) {

        // ✅ validation métier
        if (livre.getTitre() == null || livre.getTitre().isEmpty()) {
            throw new RuntimeException("Le titre est obligatoire");
        }

        if (livre.getAuteur() == null || livre.getAuteur().isEmpty()) {
            throw new RuntimeException("L'auteur est obligatoire");
        }

        // ✅ éviter doublon ISBN (optionnel mais pro)
        if (livre.getIsbn() != null) {
            boolean exists = livreRepository.existsByIsbn(livre.getIsbn());

            if (exists && livre.getId() == null) {
                throw new RuntimeException("ISBN déjà existant");
            }
        }

        return livreRepository.save(livre);
    }

    // 🔹 3. Supprimer un livre
    public void deleteLivre(Long id) {

        // ✅ vérifier existence
        if (!livreRepository.existsById(id)) {
            throw new RuntimeException("Livre introuvable");
        }

        livreRepository.deleteById(id);
    }

    // 🔹 4. Rechercher par titre
    public List<Livre> searchByTitre(String titre) {

        if (titre == null || titre.isEmpty()) {
            throw new RuntimeException("Le titre de recherche est vide");
        }

        return livreRepository.findByTitreContainingIgnoreCase(titre);
    }

    // 🔹 5. Récupérer livres disponibles
    public List<Livre> getLivresDisponibles() {
        return livreRepository.findByDisponibleTrue();
    }

    // 🔹 6. Récupérer un livre par ID (TRÈS IMPORTANT)
    public Livre getLivreById(Long id) {
        return livreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livre introuvable avec id : " + id));
    }
}
