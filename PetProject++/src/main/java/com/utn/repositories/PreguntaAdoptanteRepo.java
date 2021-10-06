package com.utn.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.utn.models.ongs.PreguntaAdoptante;

public class PreguntaAdoptanteRepo implements IPreguntaAdoptanteRepo{
    private EntityManagerFactory emf;
	private EntityManager manager;

	public PreguntaAdoptanteRepo() {
		this.emf = Persistence.createEntityManagerFactory("Persistencia");
		this.manager = emf.createEntityManager();
	}

	@SuppressWarnings("unchecked")
    @Override
    public Iterable<PreguntaAdoptante> GetPreguntasAdoptante() {
        Iterable<PreguntaAdoptante> aux;

        this.manager.getTransaction().begin();
        aux = this.manager.createQuery("FROM Caracteristica").getResultList();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public PreguntaAdoptante GetPreguntaAdoptanteById(Integer id) {
        PreguntaAdoptante aux;

        this.manager.getTransaction().begin();
        aux = (PreguntaAdoptante) this.manager.createQuery("FROM PreguntaAdoptante u WHERE u.id = " + id.toString()).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }

    @Override
    public PreguntaAdoptante CreatePreguntaAdoptante(PreguntaAdoptante PreguntaAdoptante) {

        this.manager.getTransaction().begin();
        this.manager.persist(PreguntaAdoptante);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return PreguntaAdoptante;
    }

    @Override
    public PreguntaAdoptante UpdatePreguntaAdoptante(PreguntaAdoptante PreguntaAdoptante, Integer id) {
        PreguntaAdoptante PreguntaAdoptanteToUpdate = this.GetPreguntaAdoptanteById(id);

        this.manager.getTransaction().begin();
        PreguntaAdoptanteToUpdate.setOrganizacion(PreguntaAdoptante.getOrganizacion());
        PreguntaAdoptanteToUpdate.setPregunta(PreguntaAdoptante.getPregunta());
        PreguntaAdoptanteToUpdate.setTipoPregunta(PreguntaAdoptante.getTipoPregunta());
        this.manager.flush();
        this.manager.getTransaction().commit();

        return PreguntaAdoptanteToUpdate;
    }

    @Override
    public void DeletePreguntaAdoptante(Integer id) {
        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from PreguntaAdoptante WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();
    }

}
