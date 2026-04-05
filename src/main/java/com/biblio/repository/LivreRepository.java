package com.biblio.repository;

import com.biblio.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> { // Entité + type clé primaire

    List<Livre> findByTitreContainingIgnoreCase(String titre);

    List<Livre> findByDisponibleTrue();
    // SELECT * FROM livre
   // WHERE LOWER(titre) LIKE LOWER('%mot%');
    boolean existsByIsbn(String isbn);
}

