package com.utn.controllers;

import com.utn.services.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publications")
public class PublicationController {

    @Autowired
    IPublicationService publicationService;

    @GetMapping
    public Iterable<Publication> GetPublications() {
        return publicationService.GetPublications();
    }

    @GetMapping("/{id}")
    public Publication GetPublicationById(@PathVariable Integer id) {
        return publicationService.GetPublicationById(id);
    }

    @PostMapping
    public Publication CreatePublication(@RequestBody Publication publication) {
        return publicationService.CreatePublication(publication);
    }

    @PutMapping("/{id}")
    public Publication UpdatePublication(@RequestBody Publication publication, @PathVariable Integer id) {
        return publicationService.UpdatePublication(publication, id);
    }

    @DeleteMapping("/{id}")
    public void DeletePublication(@PathVariable Integer id) {
        publicationService.DeletePublication(id);
    }
}
