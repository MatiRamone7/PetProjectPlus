package com.utn.services;

import com.utn.repositories.IPublicationRepo;
import com.utn.repositories.PublicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Servicios de publications.
 *
 * @author Grupo 14
 * @see Publication
 * @see PublicationRepo
 */
@Service
public class PublicationService implements IPublicationService{
    @Autowired
    IPublicationRepo publicationRepo;

    /**
     * Retorna la lista de publications.
     *
     * @return lista de publications
     */
    @Override
    public Iterable<Publication> GetPublications() {
        return publicationRepo.GetPublications();
    }

    /**
     * Busca una publication por Id.
     *
     * @param id id de publication a buscar
     * @return publication existente
     */
    @Override
    public Publication GetPublicationById(Integer id) {
        return publicationRepo.GetPublicationById(id);
    }

    /**
     * Crea una nueva publication.
     *
     * @param publication publication a crear
     * @return nueva publication
     */
    public Publication CreatePublication(Publication publication) {
        String path = publication.getFoto();
        String pathNormalizado = this.scaleImage(path, 100,100);

        publication.setFoto(pathNormalizado);

        return publicationRepo.CreatePublication(publication);
    }

    /**
     * Actualiza publication existente.
     *
     * @param publication publication a actualizar
     * @return publication actualizado
     */
    public Publication UpdatePublication(Publication publication, Integer id) {
        return publicationRepo.UpdatePublication(publication, id);
    }

    /**
     * Borra publication existente.
     *
     * @param id id de publication a eliminar
     */
    public void DeletePublication(Integer id) {
        publicationRepo.DeletePublication(id);
    }

    String pathAGuardar = "/pathgenerico";

    public String scaleImage(String path,int largo , int ancho) {
        try {
            //Una implementación de la interfaz de iconos que pinta iconos a partir de imágenes, mediante una url
            ImageIcon ii = new ImageIcon(path);
            //la clase BufferedImage se usa para mantener una representación de una imagen en memoria
            BufferedImage bi = new BufferedImage(ancho, largo, BufferedImage.TYPE_INT_RGB);
            //crea un graphic que se puede usar para dibujar en este buffer
            Graphics2D g2d = (Graphics2D) bi.createGraphics();
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY));
            boolean b = g2d.drawImage(ii.getImage(), 0, 0, ancho, largo, null);
            System.out.println(b);
            ImageIO.write(bi, "png", new File(pathAGuardar));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathAGuardar;
    }
}
