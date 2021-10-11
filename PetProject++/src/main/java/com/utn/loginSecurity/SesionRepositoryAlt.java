package com.utn.loginSecurity;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.utn.models.forms.FormularioMascotaPerdida;
import com.utn.models.users.Sesion;
import org.springframework.stereotype.Repository;

@Repository
public class SesionRepositoryAlt implements ISesionRepositoryAlt {

    private EntityManagerFactory emf;
    private EntityManager manager;

    public SesionRepositoryAlt() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
    }
    @Override
    public Optional<Sesion> findByUsername(String username) {
        Optional<Sesion> aux = null;

        this.manager.getTransaction().begin();
        //aux =
        aux = (Optional<Sesion>) this.manager.createQuery("FROM Sesion u WHERE u.username = " + username).getSingleResult();
        this.manager.getTransaction().commit();

        return aux;
    }
    
}
