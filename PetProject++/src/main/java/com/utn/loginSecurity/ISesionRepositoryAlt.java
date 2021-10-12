package com.utn.loginSecurity;

import java.util.Optional;
import com.utn.models.users.Sesion;

public interface ISesionRepositoryAlt {
    public Optional<Sesion> findByUsername(String username);
}
