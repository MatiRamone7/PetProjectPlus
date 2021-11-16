package com.utn.login.repository;

import java.util.Optional;
import com.utn.models.users.Sesion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionRepository extends CrudRepository<Sesion, Long> {
    public Optional<Sesion> findByUsername(String username);
}