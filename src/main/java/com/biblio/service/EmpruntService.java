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

        if (!livre.isDisponible()) {
            throw new RuntimeException("Livre non disponible");
        }

        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        livre.setDisponible(false);

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

        emprunt.setDateRetourReelle(LocalDate.now());

        Livre livre = emprunt.getLivre();
        livre.setDisponible(true);

        return empruntRepository.save(emprunt);
    }
}
