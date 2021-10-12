package com.utn.repositories;

import java.util.Optional;
import com.utn.models.users.Sesion;

public interface ISesionRepository {
    public Optional<Sesion> findByUsername(String username);
}
