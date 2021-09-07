package com.utn.repositories;

import com.utn.models.forms.FormularioDarEnAdopcion;
import com.utn.models.forms.FormularioIntencionAdopcion;
import com.utn.models.forms.FormularioMascotaEncontrada;
import com.utn.models.forms.FormularioMascotaPerdida;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Repository
public class FormRepo implements IFormRepo{

    /**
        Form Mascota Perdida
    **/

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
        formToUpdate.setCaracteristicas(form.getCaracteristicas());
        formToUpdate.setFotos(form.getFotos());
        formToUpdate.setOrganizacion(form.getOrganizacion());
       // formToUpdate.setMascota(form.getMascota());
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
        Query query = this.manager.createQuery("delete from FormularioMascotaPerdida WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();

    }

    /**
        Form Mascota Encontrada
    **/
    @Override
    public Iterable<FormularioMascotaEncontrada> GetFormsMascotaEncontrada(){
        Iterable<FormularioMascotaEncontrada> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM FormularioMascotaEncontrada").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public FormularioMascotaEncontrada GetFormMascotaEncontradaById(Integer id){
        FormularioMascotaEncontrada aux;

        this.manager.getTransaction().begin();
        aux = (FormularioMascotaEncontrada) this.manager.createQuery("FROM FormularioMascotaEncontrada u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public FormularioMascotaEncontrada CreateFormMascotaEncontrada(FormularioMascotaEncontrada form){

        this.manager.getTransaction().begin();
        this.manager.persist(form);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return form;
    }

    @Override
    public FormularioMascotaEncontrada UpdateFormMascotaEncontrada(FormularioMascotaEncontrada form, Integer id){

        FormularioMascotaEncontrada formToUpdate = this.GetFormMascotaEncontradaById(id);

        this.manager.getTransaction().begin();
        formToUpdate.setFechaHora(form.getFechaHora());
        formToUpdate.setFormularioMascotaPerdida(form.getFormularioMascotaPerdida());
        formToUpdate.setUsuario(form.getUsuario());
        this.manager.flush();
        this.manager.getTransaction().commit();

        return formToUpdate;
    }

    @Override
    public void DeleteFormMascotaEncontrada(Integer id){

        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from FormularioMascotaEncontrada WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();

    }


    /**
        Form Intencion Adopcion
    **/

    @Override
    public Iterable<FormularioIntencionAdopcion> GetFormsIntencionAdopcion(){
        Iterable<FormularioIntencionAdopcion> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM FormularioIntencionAdopcion").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public FormularioIntencionAdopcion GetFormIntencionAdopcionById(Integer id){
        FormularioIntencionAdopcion aux;

        this.manager.getTransaction().begin();
        aux = (FormularioIntencionAdopcion) this.manager.createQuery("FROM FormularioIntencionAdopcion u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public FormularioIntencionAdopcion CreateFormIntencionAdopcion(FormularioIntencionAdopcion form){

        this.manager.getTransaction().begin();
        this.manager.persist(form);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return form;
    }

    @Override
    public FormularioIntencionAdopcion UpdateFormIntencionAdopcion(FormularioIntencionAdopcion form, Integer id){

        FormularioIntencionAdopcion formToUpdate = this.GetFormIntencionAdopcionById(id);

        this.manager.getTransaction().begin();
        formToUpdate.setEstado(form.getEstado());
        formToUpdate.setSolicitante(form.getSolicitante());
        formToUpdate.setPreferencias(form.getPreferencias());
        this.manager.flush();
        this.manager.getTransaction().commit();

        return formToUpdate;
    }

    @Override
    public void DeleteFormIntencionAdopcion(Integer id){
        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from FormularioIntencionAdopcion WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();
    }


    /**
        Form Dar Adopcion
    **/
    @Override
    public Iterable<FormularioDarEnAdopcion> GetFormsDarEnAdopcion(){
        Iterable<FormularioDarEnAdopcion> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM FormularioDarEnAdopcion").getResultList();
        this.manager.getTransaction().commit();

        return aux;

    }

    @Override
    public FormularioDarEnAdopcion GetFormDarEnAdopcionById(Integer id){
        FormularioDarEnAdopcion aux;

        this.manager.getTransaction().begin();
        aux = (FormularioDarEnAdopcion) this.manager.createQuery("FROM FormularioDarEnAdopcion u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;

    }

    @Override
    public FormularioDarEnAdopcion CreateFormDarEnAdopcion(FormularioDarEnAdopcion form){

        this.manager.getTransaction().begin();
        this.manager.persist(form);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return form;
    }

    @Override
    public FormularioDarEnAdopcion UpdateFormDarEnAdopcion(FormularioDarEnAdopcion form, Integer id){

        FormularioDarEnAdopcion formToUpdate = this.GetFormDarEnAdopcionById(id);

        this.manager.getTransaction().begin();
        formToUpdate.setUsuario(form.getUsuario());
        formToUpdate.setMascota(form.getMascota());
        formToUpdate.setOrganizacion(form.getOrganizacion());
        formToUpdate.setEstado(form.getEstado());
        formToUpdate.setPreguntas(form.getPreguntas());
        this.manager.flush();
        this.manager.getTransaction().commit();

        return formToUpdate;
    }

    @Override
    public void DeleteFormDarEnAdopcion(Integer id){
        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from FormularioDarEnAdopcion WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();
    }
}
