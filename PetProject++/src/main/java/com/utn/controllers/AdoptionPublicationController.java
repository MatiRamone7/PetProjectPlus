package com.utn.controllers;

import com.utn.models.AdoptionPublication;
import com.utn.services.IAdoptionPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publications")
public class AdoptionPublicationController {
    /**
     * Controlador de publications.
     */
    @Autowired
    IAdoptionPublicationService publicationService;

    @GetMapping("/adopcion")
    public Iterable<AdoptionPublication> GetAdoptionPublications() {
        return publicationService.GetAdoptionPublications();
    }

    @GetMapping("/adopcion/{id}")
    public AdoptionPublication GetAdoptionPublicationById(@PathVariable Integer id) {
        return publicationService.GetAdoptionPublicationById(id);
    }

    @PostMapping("/adopcion")
    public AdoptionPublication CreateAdoptionPublication(@RequestBody AdoptionPublication publication) {
        return publicationService.CreateAdoptionPublication(publication);
    }

    @DeleteMapping("/adopcion/{id}")
    public void DeleteAdoptionPublication(@PathVariable Integer id) {
        publicationService.DeleteAdoptionPublication(id);
    }
}
