package com.biblio.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateEmprunt; // Date sans heure

    private LocalDate dateRetourPrevue;

    private LocalDate dateRetourReelle;

    @ManyToOne
    @JoinColumn(name = "livre_id", nullable = false) // Plusieurs emprunts → un seul livre
    private Livre livre;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false) // Plusieurs emprunts → un seul utilisateur
    private Utilisateur utilisateur;

    public Emprunt() {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public void setDateRetourPrevue(LocalDate dateRetourPrevue) {
        this.dateRetourPrevue = dateRetourPrevue;
    }

    public LocalDate getDateRetourReelle() {
        return dateRetourReelle;
    }

    public void setDateRetourReelle(LocalDate dateRetourReelle) {
        this.dateRetourReelle = dateRetourReelle;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
