package com.biblio.controller;

import com.biblio.model.Emprunt;
import com.biblio.service.EmpruntService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emprunts")
public class EmpruntController {

    private final EmpruntService empruntService;

    public EmpruntController(EmpruntService empruntService) {
        this.empruntService = empruntService;
    }

    // 🔹 1. Emprunter un livre
    @PostMapping("/emprunter")
    public Emprunt emprunter(@RequestParam Long livreId,
                             @RequestParam Long utilisateurId) {
        return empruntService.emprunter(livreId, utilisateurId);
    }

    // 🔹 2. Retourner un livre
    @PostMapping("/retourner")
    public Emprunt retourner(@RequestParam Long empruntId) {
        return empruntService.retourner(empruntId);
    }
}
