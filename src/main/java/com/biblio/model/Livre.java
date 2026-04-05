package com.biblio.model;

import jakarta.persistence.*;
import java.util.List;

@Entity // CA veut dire la classe Livre est un tableau dans base de donnee
public class Livre {

    @Id // clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue= Auto increment  IDENTITY = la base génère la valeur
    private Long id;

    @Column(nullable = false) // non null
    private String titre;

    @Column(nullable = false)
    private String auteur;

    private String isbn; // optionelle

    private int anneePublication; // Type primitif int → jamais null

    private boolean disponible = true;

    @OneToMany(mappedBy = "livre")
    private List<Emprunt> emprunts;

 // OneToMany = un livre peut avoir plusieurs emprunts
 //mappedBy = "livre" → la relation est gérée dans la classe Emprunt

    public Livre() {
    }
 // Constructeur vide obligatoire pour JPA.
    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}

