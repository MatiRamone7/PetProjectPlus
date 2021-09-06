package com.utn.repositories;

import com.utn.models.forms.FormularioMascotaPerdida;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Repository
public class FormRepo implements IFormRepo{

    /*
        Form Mascota Perdida
    */

    private EntityManagerFactory emf;
    private EntityManager manager;

    public FormRepo() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<FormularioMascotaPerdida> GetFormsMascotaPerdida() {
        Iterable<FormularioMascotaPerdida> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM FormularioMascotaPerdida").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public FormularioMascotaPerdida GetFormMascotaPerdidaById(Integer id) {
        FormularioMascotaPerdida aux;

        this.manager.getTransaction().begin();
        aux = (FormularioMascotaPerdida) this.manager.createQuery("FROM FormularioMascotaPerdida u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public FormularioMascotaPerdida CreateFormMascotaPerdida(FormularioMascotaPerdida form) {

        this.manager.getTransaction().begin();
        this.manager.persist(form);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return form;
    }

    @Override
    public FormularioMascotaPerdida UpdateFormMascotaPerdida(FormularioMascotaPerdida form, Integer id) {

        FormularioMascotaPerdida formToUpdate = this.GetFormMascotaPerdidaById(id);

        this.manager.getTransaction().begin();
        formToUpdate.setDescripcion(form.getDescripcion());
        formToUpdate.setLugarEncuentroMascota(form.getLugarEncuentroMascota());
        formToUpdate.setCaracteristicasDeLaPublicacionDelHogar(form.getCaracteristicasDeLaPublicacionDelHogar());
        formToUpdate.setFotos(form.getFotos());
        formToUpdate.setOrganizacion(form.getOrganizacion());
        formToUpdate.setTamanio(form.getTamanio());
        formToUpdate.setMascota(form.getMascota());
        formToUpdate.setEspecie(form.getEspecie());
        formToUpdate.setEstado(form.getEstado());
        formToUpdate.setHogar(form.getHogar());
        this.manager.flush();
        this.manager.getTransaction().commit();

        return formToUpdate;
    }

    @Override
    public void DeleteFormMascotaPerdida(Integer id) {

        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from Pet WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();

    }

    /*
        Form Mascota Encontrada
    */

    /*
        Form Intencion Adopcion
    */

    /*
        Form Dar Adopcion
    */
}
