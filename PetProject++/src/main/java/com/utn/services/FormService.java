package com.utn.services;

import com.utn.models.forms.FormularioMascotaPerdida;
import com.utn.repositories.FormRepo;
import com.utn.repositories.IFormRepo;
import com.utn.repositories.IPetRepo;
import com.utn.repositories.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de pets.
 *
 * @author Grupo 14
 * @see FormularioMascotaPerdida
 * @see FormRepo
 */
@Service
public class FormService implements IFormService {

    /*
        Form FormularioMascotaPerdida Perdida
    */

    @Autowired
    IFormRepo formRepo;

    /**
     * Retorna la lista de forms.
     *
     * @return lista de forms
     */
    @Override
    public Iterable<FormularioMascotaPerdida> GetFormsMascotaPerdida() {
        return formRepo.GetFormsMascotaPerdida();
    }

    /**
     * Busca un form por Id.
     *
     * @param id id de form a buscar
     * @return form existente
     */
    @Override
    public FormularioMascotaPerdida GetFormMascotaPerdidaById(Integer id) {
        return formRepo.GetFormMascotaPerdidaById(id);
    }

    /**
     * Crea un nuevo form mascota perdida.
     *
     * @param form form a crear
     * @return nuevo form
     */
    public FormularioMascotaPerdida CreateFormMascotaPerdida(FormularioMascotaPerdida form) {
        return formRepo.CreateFormMascotaPerdida(form);
    }

    /**
     * Actualiza form existente.
     *
     * @param form form a actualizar
     * @return form actualizado
     */
    public FormularioMascotaPerdida UpdateFormMascotaPerdida(FormularioMascotaPerdida form, Integer id) {
        return formRepo.UpdateFormMascotaPerdida(form, id);
    }

    /**
     * Borra form mascota perdida existente.
     *
     * @param id id de form mascota perdida a eliminar
     */
    public void DeleteFormMascotaPerdida(Integer id) {
        formRepo.DeleteFormMascotaPerdida(id);
    }

    /*
        Form FormularioMascotaPerdida Encontrada
    */

    /*
        Form Intencion Adopcion
    */

    /*
        Form Dar Adopcion
    */
}
