package com.biblio.service;

import com.biblio.model.*;
import com.biblio.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmpruntService {

    private final EmpruntRepository empruntRepository;
    private final LivreRepository livreRepository;
    private final UtilisateurRepository utilisateurRepository;

    public EmpruntService(EmpruntRepository empruntRepository,
                          LivreRepository livreRepository,
                          UtilisateurRepository utilisateurRepository) {
        this.empruntRepository = empruntRepository;
        this.livreRepository = livreRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public Emprunt emprunter(Long livreId, Long utilisateurId) {

        Livre livre = livreRepository.findById(livreId)
                .orElseThrow(() -> new RuntimeException("Livre introuvable"));

        // 🔥 VRAIE vérification
        if (empruntRepository.findByLivreAndDateRetourReelleIsNull(livre).isPresent()) {
            throw new RuntimeException("Livre déjà emprunté");
        }

        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        livre.setDisponible(false);
        livreRepository.save(livre);

        Emprunt emprunt = new Emprunt();
        emprunt.setLivre(livre);
        emprunt.setUtilisateur(utilisateur);
        emprunt.setDateEmprunt(LocalDate.now());
        emprunt.setDateRetourPrevue(LocalDate.now().plusDays(14));

        return empruntRepository.save(emprunt);
    }

    public Emprunt retourner(Long empruntId) {

        Emprunt emprunt = empruntRepository.findById(empruntId)
                .orElseThrow(() -> new RuntimeException("Emprunt introuvable"));

        // 🔥 sécurité
        if (emprunt.getDateRetourReelle() != null) {
            throw new RuntimeException("Livre déjà retourné");
        }

        emprunt.setDateRetourReelle(LocalDate.now());

        Livre livre = emprunt.getLivre();
        livre.setDisponible(true);
        livreRepository.save(livre);

        return empruntRepository.save(emprunt);
    }
}
