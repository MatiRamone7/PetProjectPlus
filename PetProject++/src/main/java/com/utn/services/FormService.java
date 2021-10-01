package com.utn.services;

import com.utn.models.forms.FormularioDarEnAdopcion;
import com.utn.models.forms.FormularioIntencionAdopcion;
import com.utn.models.forms.FormularioMascotaEncontrada;
import com.utn.models.forms.FormularioMascotaPerdida;
import com.utn.repositories.FormRepo;
import com.utn.repositories.IFormRepo;
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

    public FormService(IFormRepo formRepo) {
        this.formRepo = formRepo;
    }

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
    @Override
    public FormularioMascotaPerdida CreateFormMascotaPerdida(FormularioMascotaPerdida form) {
        return formRepo.CreateFormMascotaPerdida(form);
    }

    /**
     * Actualiza form existente.
     *
     * @param form form a actualizar
     * @return form actualizado
     */
    @Override
    public FormularioMascotaPerdida UpdateFormMascotaPerdida(FormularioMascotaPerdida form, Integer id) {
        return formRepo.UpdateFormMascotaPerdida(form, id);
    }

    /**
     * Borra form mascota perdida existente.
     *
     * @param id id de form mascota perdida a eliminar
     */
    @Override
    public void DeleteFormMascotaPerdida(Integer id) {
        formRepo.DeleteFormMascotaPerdida(id);
    }

    /*
        Form Mascota Encontrada
    */
    /**
     * Retorna la lista de forms.
     *
     * @return lista de forms
     */
    @Override
    public Iterable<FormularioMascotaEncontrada> GetFormsMascotaEncontrada(){
        return formRepo.GetFormsMascotaEncontrada();
    }

    /**
     * Busca un form por Id.
     *
     * @param id id de form a buscar
     * @return form existente
     */
    @Override
    public FormularioMascotaEncontrada GetFormMascotaEncontradaById(Integer id){
        return formRepo.GetFormMascotaEncontradaById(id);
    }

    /**
     * Crea un nuevo form mascota encontrada.
     *
     * @param form form a crear
     * @return nuevo form
     */
    @Override
    public FormularioMascotaEncontrada CreateFormMascotaEncontrada(FormularioMascotaEncontrada form){
        return formRepo.CreateFormMascotaEncontrada(form);
    }

    /**
     * Actualiza form existente.
     *
     * @param form form a actualizar
     * @return form actualizado
     */
    @Override
    public FormularioMascotaEncontrada UpdateFormMascotaEncontrada(FormularioMascotaEncontrada form, Integer id){
        return formRepo.UpdateFormMascotaEncontrada(form, id);
    }

    /**
     * Borra form mascota encontrada existente.
     *
     * @param id id de form mascota perdida a eliminar
     */
    @Override
    public void DeleteFormMascotaEncontrada(Integer id){
        formRepo.DeleteFormMascotaEncontrada(id);
    }

    /*
        Form Intencion Adopcion
    */
    /**
     * Retorna la lista de forms.
     *
     * @return lista de forms
     */
    @Override
    public Iterable<FormularioIntencionAdopcion> GetFormsIntencionAdopcion(){
        return formRepo.GetFormsIntencionAdopcion();
    }

    /**
     * Busca un form por Id.
     *
     * @param id id de form a buscar
     * @return form existente
     */
    @Override
    public FormularioIntencionAdopcion GetFormIntencionAdopcionById(Integer id){
        return formRepo.GetFormIntencionAdopcionById(id);
    }

    /**
     * Crea un nuevo form intencion de adoptar.
     *
     * @param form form a crear
     * @return nuevo form
     */
    @Override
    public FormularioIntencionAdopcion CreateFormIntencionAdopcion(FormularioIntencionAdopcion form){
        return formRepo.CreateFormIntencionAdopcion(form);
    }

    /**
     * Actualiza form existente.
     *
     * @param form form a actualizar
     * @return form actualizado
     */
    @Override
    public FormularioIntencionAdopcion UpdateFormIntencionAdopcion(FormularioIntencionAdopcion form, Integer id){
        return formRepo.UpdateFormIntencionAdopcion(form, id);
    }

    /**
     * Borra form mascota encontrada existente.
     *
     * @param id id de form mascota perdida a eliminar
     */
    @Override
    public void DeleteFormIntencionAdopcion(Integer id){
        formRepo.DeleteFormIntencionAdopcion(id);
    }

    /*
        Form Dar Adopcion
    */
    /**
     * Retorna la lista de forms.
     *
     * @return lista de forms
     */
    @Override
    public Iterable<FormularioDarEnAdopcion> GetFormsDarEnAdopcion(){
        return formRepo.GetFormsDarEnAdopcion();
    }

    /**
     * Busca un form por Id.
     *
     * @param id id de form a buscar
     * @return form existente
     */
    @Override
    public FormularioDarEnAdopcion GetFormDarEnAdopcionById(Integer id){
        return formRepo.GetFormDarEnAdopcionById(id);
    }

    /**
     * Crea un nuevo form dar en adopcion.
     *
     * @param form form a crear
     * @return nuevo form
     */
    @Override
    public FormularioDarEnAdopcion CreateFormDarEnAdopcion(FormularioDarEnAdopcion form){
        return formRepo.CreateFormDarEnAdopcion(form);
    }

    /**
     * Actualiza form existente.
     *
     * @param form form a actualizar
     * @return form actualizado
     */
    @Override
    public FormularioDarEnAdopcion UpdateFormDarEnAdopcion(FormularioDarEnAdopcion form, Integer id){
        return formRepo.UpdateFormDarEnAdopcion(form, id);
    }

    /**
     * Borra form mascota encontrada existente.
     *
     * @param id id de form mascota perdida a eliminar
     */
    @Override
    public void DeleteFormDarEnAdopcion(Integer id){
    formRepo.DeleteFormDarEnAdopcion(id);
    }
}
