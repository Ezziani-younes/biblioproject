package com.biblio.repository;

import com.biblio.model.Emprunt;
import com.biblio.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

    Optional<Emprunt> findByLivreAndDateRetourReelleIsNull(Livre livre);
    //ELECT * FROM emprunt
    //WHERE livre_id = ?
    //AND date_retour_reelle IS NULL;
}

